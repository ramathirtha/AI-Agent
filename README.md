# AI Utilities Service

This service provides utilities for interacting with the Gemini API.

## Prerequisites

* Java Development Kit (JDK) 17 or later
* Gradle
* A Gemini API key

## Configuration

Obtain a Gemini API key from the Google AI Studio or Google Cloud.

Create an `application.yml` file in `src/main/resources` if it doesn't exist, and add the following configuration, replacing `YOUR_GEMINI_API_KEY` with your actual API key:

```yaml
gemini:
  api:
    key: YOUR_GEMINI_API_KEY
```

## Building and Running

Navigate to the root directory of the project in your terminal.

Build the project using Gradle:

```bash
./gradlew clean build
```

Run the application:

```bash
java -jar build/libs/ai-utilities-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the application directly using the Spring Boot plugin:

```bash
./gradlew bootRun
```

The service should now be running and accessible.

## Endpoints

* `/gemini-pro-vision/document`: Endpoint for analyzing documents with Gemini Pro Vision.
* `/gemini-pro-vision/generate-text`: Endpoint for generating text with Gemini Pro.

Refer to the controller code for detailed request parameters.
