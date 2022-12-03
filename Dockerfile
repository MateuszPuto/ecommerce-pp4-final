FROM maven:3.8.6-eclipse-temurin-11-alpine
WORKDIR /app
COPY pom.xml ./
RUN mvn dependency:resolve
COPY src ./src
RUN mvn test
CMD ["mvn", "spring-boot:run"]