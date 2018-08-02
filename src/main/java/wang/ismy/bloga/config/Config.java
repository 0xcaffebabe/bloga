package wang.ismy.bloga.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
public class Config {
    private String id="LTAI8M8FEYq6S0ph";

    private String secret="cpXqlYzPPo4TaCYKfR18VROXJJ9jAF";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
