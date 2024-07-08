FROM maven:3.9.8-amazoncorretto-21
ENV HOME=/app
RUN mkdir -p $HOME
WORKDIR $HOME
COPY . .
RUN mvn clean install
WORKDIR ./target
CMD ["java", "-jar", "minio-0.0.1-SNAPSHOT.jar"]