# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="mihir.iiest@gmail.com"

COPY ./target/exchange_rate_service-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch exchange_rate_service-0.0.1-SNAPSHOT.jar'

EXPOSE 8001

ENTRYPOINT ["java","-jar","exchange_rate_service-0.0.1-SNAPSHOT.jar"]