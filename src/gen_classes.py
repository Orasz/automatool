#!/usr/bin/env python3
import argparse
import os


parser = argparse.ArgumentParser(description='Generate Dto, Model and Resource classes for given json files.')
parser.add_argument('input_json', type=str,
                    help='Set json input file')
parser.add_argument('output_json', type=str, 
                    help='Set json output file')
parser.add_argument('--packages-dir', dest='packages_dir',
                    default='./packages/', type=str,
                    help='Packages default output directory\nDefault: [./packages]')
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

input_json = args.input_json
output_json = args.output_json
output_dir = args.packages_dir
bin_file = args.bin
file_type = args.file_type
annotation_style = args.annotation_style

assert os.path.isfile(input_json)
assert os.path.isfile(output_json)

if not os.path.isdir(output_dir):
    print(f"Creating packages dir at {output_dir}")
    os.makedirs(output_dir)
else:
    print(f"Waring output directory {output_dir} already present")

print(f"Writing classes in {output_dir}")

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
    'output_name': 'outputResource',
    'suffix': 'Resurce'}]

for el in to_gen:
    out_path = os.path.join(output_dir, el['output_name'])
    print(f"Generating {el['output_name']} at {out_path}")
    os.system(f"{bin_file} --source {input_json} --target {out_path} -a {annotation_style} -x {el['suffix']} -T {file_type}")
