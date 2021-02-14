#EXCHANGE_RATE_SERVICE



API 1 -->  To Get base conversion rate from currency1 to EURO --- USD/EUR, HUF/EUR

API2 -->  To  GET conversion rate from  C1 to C2 , Derive it from base conversion ration

API3 -->  To get List of supported currency and see how many times this currency requested for conversion

API4 --> To convert one currency into another currency ,Update currency_exchange_request_history table 

API5 --> To get the link of reference public website


DB tables 
------------
BASE_CURRENCY_EXCHANGE_RATE  - Stores base ration with EURO 
[id,currency_from,currency_to,CONVERSION_MULTIPLE,port]
CURRENCY_EXCHANGE_REQUEST_HISTORY
[id,CURRENCY_FROM,CURRENCY_TO,conversion_multiple,port]

1 EUR = 87.90 INR
1 EUR = 1.21 USD


http://localhost:8081/swagger-ui.html#/exchange-rate-controller
http://localhost:8080/h2-console

mvn install -DskipTests

