package com.example.graphqlcli.commands;

import com.example.graphqlcli.client.GraphQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "list-assignments", description = "Lists assignments for a specific course.")
public class ListAssignmentsCommand implements Runnable {

    @Autowired
    private GraphQLService graphQLService;

    @Parameters(index = "0", description = "The course ID to list assignments for.")
    private String courseId;

    @Option(names = "--token", required = true, description = "API token for authentication")
    private String token;

    @Option(names = {"--active", "--no-active"}, description = "Whether to list active assignments only.")
    private boolean active = true;

    @Override
    public void run() {
        graphQLService.fetchAssignmentsForCourse(courseId, token, active)
                .subscribe(System.out::println, error -> System.err.println("Error: " + error.getMessage()));
    }
}
