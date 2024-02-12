import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GraphQLService {

    private static final Logger logger = LoggerFactory.getLogger(GraphQLService.class);

    private final WebClient webClient;

    // Constructor

    public Mono<String> fetchActiveCourses(String token) {
        logger.info("Fetching active courses using GraphQL");
        // Implementation...
    }

    public Mono<String> fetchAssignmentsForCourse(String courseId, String token, boolean active) {
        logger.info("Fetching assignments for course {} using GraphQL", courseId);

    }
}
