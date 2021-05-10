package org.piterconsulting;

import org.piterconsulting.repository.InMemoryClientRepository;
import org.piterconsulting.repository.annotation.InMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;

@Configuration
public class RepositoryConfiguration {

    @Bean
    @InMemoryRepository
    public InMemoryClientRepository repository(){
        return  new InMemoryClientRepository(new LinkedList<>());
    }
}
