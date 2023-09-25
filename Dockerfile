FROM maven as builder
WORKDIR /usr/src/mymaven
COPY . .

RUN mvn clean package


FROM openjdk:19
WORKDIR /app
COPY --from=builder /usr/src/mymaven/target/servidor-0.1.jar ./app.jar
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]