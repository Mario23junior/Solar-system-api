<p align="center"><img src="logo/logo.gif" width = "833px" height="433px"></p>

<h1 align="center">System Solar API</h1>

<h3 align="center">
API REST de código aberto para dados de consulta de  pesquisa  as informações nelas contidadas com o objetivo de estabelecer resultados relevantes <a href="https://solarsystem.nasa.gov/" target="_blank">Nasa</a>
 <a href="https://www.iau2006.org/"usando como base organizacional um sistema de CRUD
<p align="center">
 
<a href="https://app.travis-ci.com/Mario23junior/solar-system-api.svg?branch=main" target="_blank"> [![Build Status](https://app.travis-ci.com/Mario23junior/solar-system-api.svg?branch=main)](https://app.travis-ci.com/Mario23junior/solar-system-api.svg?branch=main)
<a href="https://en.wikipedia.org/wiki/Representational_state_transfer"><img src="https://img.shields.io/badge/interface-REST-brightgreen.svg?longCache=true&style=flat-square" target="_blank"></a>
</p>
  
## Primeiro execute o maven 

## 🚀 Começando

Algums parametros de ação são necessarios para a execução
### 📋 Pré-requisitos
 
* [Java11](http://www.dropwizard.io/1.0.2/docs/)
* [Spring boot](https://spring.io/projects/spring-boot)
* [H2](https://www.h2database.com/html/main.html)
* [Swagger](https://swagger.io/)
* [openJDK](https://maven.apache.org/)
 
### 🔧 Instalação 🛠️ 

Uma série de exemplos passo-a-passo que informam o que você deve executar para ter um ambiente de desenvolvimento em execução.

Diga como essa etapa será:

```
java -jar target/systemsola-0.0.1-SNAPSHOT.jar

```
 
 ###  Documentação  
```
https://system-solar-planetary.herokuapp.com/swagger-ui/index.html
```


## Uso

```
https://system-solar-planetary.herokuapp.com/swagger-ui/index.html
```

## Resultado dos dados da API

 ```json
     [
       {
          "name":"Sun",
          "idade":4.568,
          "location":"Local Interstellar Cloud, Local Bubble, Orion–Cygnus Arm, Milky Way",
          "mass":1.0014,
          "nearestStar":"Proxima Centauri,Alpha Centauri",
          "semiEixo":"30,10 AU",
          "distanceKuiperCliff":"50U",
          "uranosDTO":[
             {
                "name":"Urano",
                "distanceSun":2.870658186,
                "surfaceArea":8083000000,
                "gravity":"8,87 m/s²",
                "radius":25.362,
                "orbitalPeriod":30799.095,
                "moons":true,
                "qtmoons":27,
                "temMedia":-195,
                "temMinima":-224,
                "temMaxima":-216,
                "systemSolarDTO":null
             }
          ],
          "venusDTO":[
             {
                "name":"Vênus",
                "distanceSun":108.2,
                "surfaceArea":496.8,
                "gravity":"8,87 m/s²",
                "radius":6.0518,
                "orbitalPeriod":225,
                "moons":false,
                "qtmoons":0,
                "temMedia":461,
                "temMinima":-220,
                "temMaxima":430,
                "systemSolarDto":null
             }
          ],
          "neptunesDTO":[
             {
                "name":"Neptune",
                "distanceSun":4.498396441,
                "surfaceArea":7618000000,
                "gravity":"11,15 m/s²",
                "radius":24.622,
                "orbitalPeriod":60225,
                "moons":true,
                "qtmoons":14,
                "temMedia":-245,
                "temMinima":-193,
                "temMaxima":-327,
                "systemSolarDto":null
             }
          ],
          "saturnsDTO":[
             {
                "name":"Saturn",
                "distanceSun":1.4294,
                "surfaceArea":42699999999.99999,
                "gravity":"10,44 m/s²",
                "radius":58.232,
                "orbitalPeriod":29.458,
                "moons":true,
                "qtmoons":82,
                "temMedia":-139,
                "temMinima":-125,
                "temMaxima":-178,
                "systemSolarDto":null
             }
          ],
          "mercuriyDTO":[
             {
                "name":"Mercury",
                "distanceSun":57.91,
                "surfaceArea":74.8,
                "gravity":"3.7 m/s²",
                "radius":2.4397,
                "orbitalPeriod":115.88,
                "moons":false,
                "qtmoons":0,
                "temMedia":166.85,
                "temMinima":-183.15,
                "temMaxima":426.85,
                "systemSolarDto":null
             }
          ],
          "marsDTO":[
             {
                "name":"Mars",
                "distanceSun":227.943824,
                "surfaceArea":144.8,
                "gravity":"3,721 m/s²",
                "radius":3.3895,
                "orbitalPeriod":687,
                "moons":true,
                "qtmoons":2,
                "temMedia":-63,
                "temMinima":-140,
                "temMaxima":20,
                "systemSolarDto":null
             }
          ],
          "jupiterDTO":[
             {
                "name":"Jupiter",
                "distanceSun":788,
                "surfaceArea":61420000000000,
                "gravity":"24,79 m/s²",
                "radius":69.911,
                "orbitalPeriod":365,
                "moons":true,
                "qtmoons":79,
                "temMedia":-110,
                "temMinima":-163,
                "temMaxima":-108,
                "systemSolarDto":null
             }
          ],
          "earthDTO":[
             {
                "name":"Earth",
                "distanceSun":15,
                "surfaceArea":510.072,
                "gravity":"9.80665 m/s2",
                "radius":6.371,
                "orbitalPeriod":225,
                "moons":true,
                "qtmoons":1,
                "temMedia":15,
                "temMinima":-89.2,
                "temMaxima":56.7,
                "systemSolarDto":null
             }
          ],
          "object":"star"
       }
    ]
 
```
 
## 📄 Licença
 
Este projeto está sob a licença (GNU GPLv3) - [GNU GPLv3.md](https://www.gnu.org/licenses/gpl-3.0.pt-br.html)
