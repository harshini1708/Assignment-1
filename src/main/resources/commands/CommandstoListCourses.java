package com.example.graphqlcli.commands;

import com.example.graphqlcli.client.GraphQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Component
@Command(name = "list-courses", description = "Lists active courses.")
public class ListCoursesCommand implements Runnable {

    @Autowired
    private GraphQLService graphQLService;

    @Option(names = "--token", required = true, description = "API token for authentication")
    private String token;

    @Option(names = {"--active", "--no-active"}, description = "Whether to list active courses only.")
    private boolean active = true;

    @Override
    public void run() {
        graphQLService.fetchActiveCourses(token, active)
                .subscribe(System.out::println, error -> System.err.println("Error: " + error.getMessage()));
    }
}
