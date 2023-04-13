package mx.edu.utez.consultorio.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "mx.edu.utez.consultorio.repository")
public class ConfiguracionMongoDB {
    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create("mongodb+srv://root:root@hospital.ygtkwrg.mongodb.net/test");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws  Exception{
        return new MongoTemplate(mongoClient(), "consultorio");
    }
}
