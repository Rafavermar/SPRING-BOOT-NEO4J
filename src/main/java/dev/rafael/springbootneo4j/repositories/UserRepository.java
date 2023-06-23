package dev.rafael.springbootneo4j.repositories;

import dev.rafael.springbootneo4j.models.User;
import dev.rafael.springbootneo4j.queryResults.CourseEnrolmentQueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


public interface UserRepository extends Neo4jRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    boolean existsByUsername( String username );
@Query("Match (user:User), (course:Course) WHERE user.username = $username AND course.identifier = $identifier" +
        "RETURN EXISTS((user)-[:ENROLLED_IN]->(course))")
    boolean findEnrolmentStatus(String username, String identifier);

@Query("Match (user:User), (course:Course) WHERE user.username = $username AND course.identifier = $identifier" +
        "CREATE (user)--[:ENROLLED_IN]->(course) RETURN user, course")
CourseEnrolmentQueryResult createEnrolmentRelationship(String username, String identifier);

}
