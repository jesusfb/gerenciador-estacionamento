package marhlonkorb.github.io.gerenciadorestacionamento.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    @ConditionalOnProperty(name = "use.postgres", havingValue = "true")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create()
                .url(applicationProperties.getPostgresUrl())
                .username(applicationProperties.getPostgresUsername())
                .password(applicationProperties.getPostgresPassword())
                .driverClassName("org.postgresql.Driver")
                .build();
    }

    @Bean
    @ConditionalOnProperty(name = "use.postgres", havingValue = "false")
    public DataSource h2DataSource() {
        return DataSourceBuilder.create()
                .url(applicationProperties.getH2Url())
                .username(applicationProperties.getH2Username())
                .password(applicationProperties.getH2Password())
                .driverClassName("org.h2.Driver")
                .build();
    }
}

