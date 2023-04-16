#!/usr/bin/env python3
import argparse
import os
from utils import edit_distance
import shutil

# Arguments handling
parser = argparse.ArgumentParser(description='Generate Dto, Model and Resource classes for given json files.')
parser.add_argument('input_json', type=str,
                    help='Set json input file')
parser.add_argument('output_json', type=str, 
                    help='Set json output file')
parser.add_argument('--out-dir', dest='out_dir',
                    default='./out/', type=str,
                    help='Default output directory\nDefault: [./out]')
parser.add_argument('--packages-dir', dest='packages_dir',
                    default='packages/', type=str,
                    help='Packages default output directory\nDefault: [./[out-dir]/packages]')
parser.add_argument('--bin', dest='bin',
                    default=os.path.join('lib', 'jsonschema2pojo-1.2.1', 'bin', 'jsonschema2pojo'), type=str,
                    help=f"Jsonschema2pojo bin file path\nDefault: [{os.path.join('./jsonschema2pojo-1.2.1', 'bin', 'jsonschema2pojo')}]")
parser.add_argument('--file_type', dest='file_type',
                    default='JSON', type=str,
                    help='JSON type. \nOptions: [JSONSCHEMA, JSON, YAMLSCHEMA, YAML]\nDefault: [JSON]')
parser.add_argument('--annotation_style', dest='annotation_style',
                    default='NONE', type=str,
                    help='Annotation style. \nOptions: [JACKSON, JACKSON2, JSONB1, JSONB2, GSON, MOSHI1, NONE]\nDefault: [NONE]')
args = parser.parse_args()


# Global vars setting
input_json = args.input_json
output_json = args.output_json
output_dir = args.out_dir
packages_dir = os.path.join(output_dir, args.packages_dir)
bin_file = args.bin
file_type = args.file_type
annotation_style = args.annotation_style


# File system prep
assert os.path.isfile(input_json)
assert os.path.isfile(output_json)

if not os.path.isdir(output_dir):
    print(f"Creating out dir at {output_dir}")
    os.makedirs(output_dir)
else:
    print(f"Warning output directory {output_dir} already present")

if not os.path.isdir(packages_dir):
    print(f"Creating packages dir at {packages_dir}")
    os.makedirs(packages_dir)
else:
    print(f"Warning output directory {packages_dir} already present")

print(f"Writing classes in {packages_dir}")




generated_classes = {}
to_gen = [{
    'input': input_json,
    'output_name': 'inputDto',
    'suffix': 'Dto'},
    {'input': input_json,
    'output_name': 'inputModel',
    'suffix': 'Model'},
    {'input': output_json,
    'output_name': 'outputModel',
    'suffix': 'Model'},
    {'input': output_json,
    'output_name': 'Resource',
    'suffix': 'Resurce'}]

# Pojo generation
for el in to_gen:
    out_path = os.path.join(packages_dir, el['output_name'])
    print(f"Generating {el['output_name']} at {out_path}")
    a = os.system(f"{bin_file} -log info --source {el['input']} --target {out_path} -a {annotation_style} -x {el['suffix']} -T {file_type}")

    files = os.listdir(out_path)
    dists = list(map(lambda file_name : edit_distance(os.path.basename(file_name.replace(el['suffix'], '')),
                                                    os.path.basename(el['input'])), files))

    generated_classes[el['output_name']] = os.path.basename(files[dists.index(min(dists))]).split('.')[-2]



# Placeholders injection
print("Writing Placeholders...")

with open('./placeholders/BusinessService.java', 'r') as f:
    business_service = f.read()

with open('./placeholders/ApiController.java', 'r') as f:
    api_controller = f.read()
    

business_service = business_service.format(OutputModel=generated_classes['outputModel'],
                                           InputModel=generated_classes['inputModel'])

api_controller = api_controller.format(InputDto=generated_classes['inputDto'],
                                       OutputModel=generated_classes['outputModel'],
                                       InputModel=generated_classes['inputModel'],
                                       Resource=generated_classes['Resource']
                                       )

with open(os.path.join(output_dir, 'BusinessService.java'), 'w') as f:
    f.write(business_service)
    print(f"Wrote BusinessService file at {os.path.join(output_dir, 'BusinessService.java')}")

with open(os.path.join(output_dir, 'ApiController.java'), 'w') as f:
    f.write(api_controller)
    print(f"Wrote ApiController file at {os.path.join(output_dir, 'ApiController.java')}")

shutil.copy('./placeholders/ApiFactory.java', os.path.join(output_dir, 'ApiFactory.java'))
shutil.copy('./placeholders/ApiAssembler.java', os.path.join(output_dir, 'ApiAssembler.java'))
