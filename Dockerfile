FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY pom.xml .
RUN mvn -B -q dependency:go-offline
COPY src ./src
RUN mvn -B -q -DskipTests package dependency:copy-dependencies

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /workspace/target/classes ./classes
COPY --from=build /workspace/target/dependency ./dependency
RUN useradd --system --uid 10001 appuser
USER 10001
EXPOSE 8080
ENV HOST=0.0.0.0 PORT=8080
CMD ["java", "-cp", "/app/classes:/app/dependency/*", "com.tutorial.backend.TaskApiServer"]
