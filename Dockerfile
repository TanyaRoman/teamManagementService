FROM maven:3.8.4-eclipse-temurin-17-alpine AS app
WORKDIR /app
COPY pom.xml pom.xml
RUN mvn dependency:go-offline -B
COPY src src
RUN mvn package -DskipTests
RUN java -Djarmode=layertools -jar /app/target/*.jar extract

FROM openjdk:17-jdk-alpine3.14
WORKDIR /app
COPY --from=app app/dependencies/ ./
COPY --from=app app/spring-boot-loader/ ./
COPY --from=app app/snapshot-dependencies/ ./
COPY --from=app app/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]