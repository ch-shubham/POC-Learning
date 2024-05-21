# Use the official OpenJDK 21 Corretto base image
FROM amazoncorretto:21 AS builder

# Define Gradle version
ENV GRADLE_VERSION=8.7

# Set Gradle environment variables
ENV GRADLE_HOME /opt/gradle
ENV GRADLE_USER_HOME /cache/.gradle

# Add Gradle binaries to PATH
ENV PATH ${PATH}:${GRADLE_HOME}/bin

# Download and install Gradle
RUN echo "Downloading Gradle" \
    && curl -sSL --output gradle.zip "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" \
    && echo "Installing Gradle" \
    && yum install -y unzip \
    && unzip -d /opt/gradle gradle.zip \
    && rm gradle.zip \
    && ln -s "/opt/gradle/gradle-${GRADLE_VERSION}/bin/gradle" /usr/bin/gradle \
    && echo "Testing Gradle installation" \
    && gradle --version


FROM alpine:3.16.9
# Set Gradle environment variables

# Define Gradle version
ENV GRADLE_VERSION=8.7
ENV GRADLE_HOME /opt/gradle
ENV JAVA_HOME /opt/corretto
ENV GRADLE_USER_HOME /cache/.gradle

# Add Gradle binaries to PATH
ENV PATH ${PATH}:${GRADLE_HOME}/bin
ENV PATH ${PATH}:${JAVA_HOME}/bin

COPY --from=builder /usr/lib/jvm/java-21-amazon-corretto /opt/corretto/21
COPY --from=builder /opt/gradle /opt/gradle
RUN ln -s "/opt/gradle/gradle-${GRADLE_VERSION}/bin/gradle" /usr/bin/gradle
RUN ln -s "/opt/corretto/21/bin/java" /usr/bin/java

