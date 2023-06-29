ARG APP_NAME=api-gateway

FROM alpine:3.17.3 AS builder
RUN mkdir -p /agent
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar /agent/opentelemetry-javaagent.jar

FROM alpine:3.17.3 AS app
ARG APP_NAME
RUN mkdir -p /app
COPY --from=builder /agent /app
WORKDIR app
COPY /${APP_NAME}.jar .
COPY /entrypoint.sh .

FROM eclipse-temurin:17-jre-focal
COPY --from=app /app /app
RUN ["chmod", "+x", "/app/entrypoint.sh"]
WORKDIR app
ENTRYPOINT ["bash", "-c", "./entrypoint.sh"]