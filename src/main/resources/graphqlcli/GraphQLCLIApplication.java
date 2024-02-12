package com.example.graphqlcli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@SpringBootApplication
public class GraphQLCLIApplication implements CommandLineRunner {

    private final IFactory factory; // Picocli's factory for dependency injection

    public GraphQLCLIApplication(IFactory factory) {
        this.factory = factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(GraphQLCLIApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
