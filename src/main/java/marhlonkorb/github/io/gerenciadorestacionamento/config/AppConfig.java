package marhlonkorb.github.io.gerenciadorestacionamento.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de Scanner de entidades
 */
@Configuration
@EntityScan(basePackages = "marhlonkorb.github.io.gerenciadorestacionamento.models.entities")
public class AppConfig {
}