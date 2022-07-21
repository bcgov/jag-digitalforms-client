# jag-digitalforms-client

A shared DIGITALFORMS client library

Used by: 
- 1. Digital Forms Reviews
- 2. Digital Forms VIPS Integration 

## Usage

Add the following dependency to your spring boot application

```xml

    <dependencies>

        <dependency>
            <groupId>ca.bc.gov.open</groupId>
            <artifactId>digitalforms-ords-client</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>

    </dependencies>

```

Configure the following properties in your `application.properties`

```
digitalforms.client.basePath=path-to-df-ords
digitalforms.client.username=username
digitalforms.client.password=password
```
