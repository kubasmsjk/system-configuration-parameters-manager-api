
﻿# system-configuration-parameters-manager-api

system-configuration-parameters-manager-api is a web service that provides an API for managing system configuration parameters. 

## Project Technology Stack:
* Spring Framework
* Maven
* JPA/Hibernate
* MySQL
* SOAP

## Functionality:
* Field Validation
* Web Service Implementation
* Testing using SoapUI

## Getting Started

First, run the dockerfile and docker-compose:
```bash
docker build -t system-configuration-parameters-manager-api .
docker compose up
```

To down docker-compose use:
```bash
docker compose down
```
Application works on localhost:8080
Database works on localhost:3306
Endpoint is on http://localhost:8081/ws

To test endpoints use this file in SoapUI:
* system-configuration-parameters-manager-soap-test-soapui-project.xml

## Author:
* Jakub Mieczkowski ([@kubasmsjk]( https://github.com/kubasmsjk))
