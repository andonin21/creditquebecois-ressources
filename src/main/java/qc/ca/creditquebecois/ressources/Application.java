package qc.ca.creditquebecois.ressources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The type Application.
 */
@EnableJpaRepositories("qc.ca.creditquebecois.ressources.repository") // Spécifiez le package contenant vos interfaces de dépôt JPA
@SpringBootApplication
public class Application {
    /**
     * The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
