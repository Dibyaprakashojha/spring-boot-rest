FROM openjdk:11
EXPOSE 8086
COPY /target/product-api.jar product-api.jar
ENTRYPOINT ["java","-jar","/product-api.jar"]