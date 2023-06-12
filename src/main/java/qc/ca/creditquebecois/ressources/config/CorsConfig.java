package qc.ca.creditquebecois.ressources.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * La classe CorsConfig implémente l'interface WebMvcConfigurer, ce qui permet de configurer les mappings CORS pour l'application
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    /**
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .maxAge(3600);
    }
}

