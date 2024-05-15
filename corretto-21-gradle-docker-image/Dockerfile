# Use the official OpenJDK 21 Corretto base image
FROM amazoncorretto:21

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

# # Set working directory
WORKDIR /app

