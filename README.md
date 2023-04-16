# automatool
Tool for automating the provisioning of a basic internal java microservice structure for an API (lol)

### High Level Description:

![high_level_ark](https://user-images.githubusercontent.com/26349651/230349320-0803094e-47e4-403e-a0da-1335a952c145.png)


### Quick Start
The simplest use-case is described by the following command

`python3 src/gen_classes.py ./data/address.schema.json ./data/complexSchema.json`



To get some help use the following command

`python3 src/gen_classes.py --help`     


### Next steps:

- Modify conversion methods to add the possibility to ignore some fields (passed as argument) during the copy;
- Add Kafka Consumer to trigger elaboration of input from Kafka topic.
