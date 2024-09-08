## java developer test assignment

### instructions for launching the application

#### 1) `maven`

```shell
mvn clean package
```
#### 2) `docker-compose`

```shell
docker-compose up
```

## description

#### this application interacts with the eureka server has four microservices and the eureka server itself

### server
#### this application uses the eureka server, all microservices will be connected to it to interact with each other
#### to view which microservices are connected to the eureka server, click on the link http://localhost:8761 / or use curl which is written below
```shell
curl -H "Accept: application/json" -X GET http://localhost:8761/eureka/apps
```


### the first `storage-of-user-information` microservice
#### it has a built-in h2 database and is populated by five users for the test mode, available via 
#### /GET uri: "http://localhost:8080/{lastname}"
| id | firstname    | lastName    | numberPhone |
|----|--------------|-------------|-------------|
| 1  | firstName №1 | lastName №1 | 1234568     |
| 2  | firstName №2 | lastName №2 | 1234569     |
| 3  | firstName №3 | lastName №3 | 1234570     |
| 4  | firstName №4 | lastName №4 | 1234571     |
| 5  | firstName №5 | lastName №5 | 1234572     |

#### returns the user with lastName=lastName №1
```shell
curl -H "Accept: application/json" -X GET http://localhost:8080/lastName%20%E2%84%961
```

### the second microservice is `storage-of-company-information`
#### it has a built-in H2 database and is populated by five companies for a test mode available via
#### /GET uri: "http://localhost:8083/?name={name}",  /GET uri: "http://localhost:8083/?id={id}"
| id | name    | budget | List<Integer> employees |
|----|---------|--------|-------------------------|
| 1  | name №1 | 11.1   | 1, 6, 7, 8, 9           |
| 2  | name №2 | 12.1   | 2, 6, 7, 8, 9           |
| 3  | name №3 | 13.1   | 3, 6, 7, 8, 9           |
| 4  | name №4 | 14.1   | 4, 6, 7, 8, 9           |
| 5  | name №5 | 15.1   | 5, 6, 7, 8, 9           |
#### return the company by name, name=name №1
```shell
curl -H "Accept: application/json" -X GET http://localhost:8083/?name=name%20%E2%84%961
```
#### return the company by individual number, id=1
```shell
curl -H "Accept: application/json" -X GET http://localhost:8083/?id=1
```

### the third microservice is `find-by-user-information`
#### uses `eureka` to access the `storage-of-user-information` microservice to obtain information about the user
#### /GET uri: "http://localhost:8081/{lastname}"
#### returns the user with lastName=lastName №1
```shell
curl -H "Accept: application/json" -X GET http://localhost:8081/lastName%20%E2%84%961
```

### the fourth microservice is `find-by-company-information`
#### uses `eureka` to access the `store-of-company-information` microservice to obtain information about the company
#### /GET uri: "http://localhost:8082/?name={name}",  /GET uri: "http://localhost:8082/?id={id}"
#### return the company by name, name=name №1
```shell
curl -H "Accept: application/json" -X GET http://localhost:8082/?name=name%20%E2%84%961
```
#### return the company by individual number, id=1
```shell
curl -H "Accept: application/json" -X GET http://localhost:8082/?id=1
```
