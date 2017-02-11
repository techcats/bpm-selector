# BMP Selector

A web service that manages playlists from your Spotify collection by monitoring your FitBit heart rate.

## Development

### Configuration

Include the following program arguments to the application launch:
```
--spring.data.mongodb.host=$MONGODB_HOST
--spring.data.mongodb.port=$MONGODB_PORT
--spring.data.mongodb.database=$MONGODB_DB_NAME
--spring.data.mongodb.username=$MONGODB_USER
--spring.data.mongodb.password=$MONGODB_PASS
```

> In best practice, do not hard code API keys or credentials.

For creating your own configuration add a Java class to "com.techcats.bpmselector.config.properties" package, for example (com/techcats/bpmselector/config/properties/EventbriteProperties.java):
```java
@Component
@ConfigurationProperties(prefix = "bpmselector.thirdparty.eventbrite", ignoreUnknownFields = true)
public class EventbriteProperties {
    
    private String apipath;
    private String token;
    
    public String getApipath() {
        return apipath;
    }
    
    public void setApipath(String apipath) {
        this.apiPath = apiPath;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
}
```

Then you can add the program argument:
```
--bpmselector.thirdparty.eventbrite.apipath=$EVENTBRITE_API_PATH
--bpmselector.thirdparty.eventbrite.token=$EVENTBRITE_TOKEN
```

### Front End Guide
See [README.md](src/main/resources/static/README.md)