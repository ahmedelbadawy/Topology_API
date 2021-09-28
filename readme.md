<h1>Topology-API<h1>

## About

> Topology-API is an API that provides the functionality to access, manage and store device topologies. 

### Built using

- main project [java](https://www.java.com/en/)
- Unit testing: [Junit](https://junit.org/junit5/).

## Getting Started

> This is an list of needed instructions to set up your project locally, to get a local copy up and running follow these instructions.
### Running

1. **_Running the application_**

```sh
$ java Main
```
- Console Commands:
    - To read a topology from a json file and store it in memory: ```read [filename]```
    - To write a topology from memory to a json file: ```write [topologyID] ```
    - To delete a certain topology from memory: ```delete [topologyID]```
    - To query all the topologies in memory: ```getTopologies ``` 
    - To query all devices of a certain topology: ```getDevices [topologyID]```
    - To query all devices of a certain topology that has a certain netlist node: ```getDevicesWithNetlistNode [topologyID] [netlistNodeID]```

2. **Running the tests**

```sh
$ java Test_topology
```
## Documentation
 > doc -> index.html
