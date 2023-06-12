package qc.ca.creditquebecois.ressources.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

/**
 * La class MongoDBConfig configure MongoDB
 */
@Configuration
public class MongoDBConfig extends AbstractMongoClientConfiguration {
    /**
     * Définie le nom de la base de données à laquelle l'application se connectera.
     * @return
     */
    @Override
    protected String getDatabaseName() {
        return "creditquebecois";
    }

    /**
     * Cette méthode crée et configure le client MongoDB utilisant les paramètres spécifiés.
     * @return
     */
    @Override
    @Bean
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }
}