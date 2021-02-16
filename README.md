#EXCHANGE_RATE_SERVICE

Exchange Rate Service exposing an API, which can be consumed by a frontend application.

Technology used
----------------------------------------
Java 8
REST API
Spring Boot
Swagger 
Lombok
Docker container
Maria DB
Maven


How to run the project
----------------------------------------
To build and run -->  mvn install -DskipTests

To create and start docker container --> docker-compose up -d --build --force-recreate -t 0 

Now application is up and running .

Swagger URL -- http://localhost:8081/swagger-ui.html#

DB tables 
------------
BASE_CURRENCY_EXCHANGE_RATE  --> to keep base currency exchange rate

CURRENCY_EXCHANGE_REQUEST_HISTORY -->to keep currency exchange request history


Use below endpoints

[API-1]POST -  http://localhost:8081/exchangeService/convertCurrencies

Request Body :- 
		{
		  "fromCurrency": "EUR",
		  "toCurrency": "USD",
		  "amount": 20
		}

[API-2] GET  - http://localhost:8081/exchangeService/baseExchangeRate/JPY/
[API-3] GET  - http://localhost:8081/exchangeService/derivedExchangeRate/USD/JPY/
[API-4] GET - http://localhost:8081/exchangeService/publicLink
[API-5] GET - http://localhost:8081/exchangeService/exchangeHistory


To access DB use Hedis SQL with below credenials -
Hostname/IP: localhost
port: 3306
User: user
password: user


To kill container after use - 
Docker-compose down

Assumptions
-----------------------------
Base currency will always EUR. Conversion between other currencies will happen based of base rate of these concurrencies
with EUR.

Improvements
-----------------------------
Code coverage and improving design part
Jenkins PCF integrations 
