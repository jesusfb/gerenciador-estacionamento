package marhlonkorb.github.io.gerenciadorestacionamento.db;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {

    private String postgresUrl;
    private String postgresUsername;
    private String postgresPassword;

    private String h2Url;
    private String h2Username;
    private String h2Password;

    public String getPostgresUrl() {
        return postgresUrl;
    }

    public void setPostgresUrl(String postgresUrl) {
        this.postgresUrl = postgresUrl;
    }

    public String getPostgresUsername() {
        return postgresUsername;
    }

    public void setPostgresUsername(String postgresUsername) {
        this.postgresUsername = postgresUsername;
    }

    public String getPostgresPassword() {
        return postgresPassword;
    }

    public void setPostgresPassword(String postgresPassword) {
        this.postgresPassword = postgresPassword;
    }

    public String getH2Url() {
        return h2Url;
    }

    public void setH2Url(String h2Url) {
        this.h2Url = h2Url;
    }

    public String getH2Username() {
        return h2Username;
    }

    public void setH2Username(String h2Username) {
        this.h2Username = h2Username;
    }

    public String getH2Password() {
        return h2Password;
    }

    public void setH2Password(String h2Password) {
        this.h2Password = h2Password;
    }
}
