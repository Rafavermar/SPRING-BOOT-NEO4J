package dev.rafael.springbootneo4j.services;

import dev.rafael.springbootneo4j.models.Course;
import dev.rafael.springbootneo4j.queryResults.CourseEnrolmentQueryResult;
import dev.rafael.springbootneo4j.repositories.CourseRepository;
import dev.rafael.springbootneo4j.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseEnrolmentService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseEnrolmentService( CourseRepository courseRepository, UserRepository userRepository ) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public Boolean getEnrolmentStatus (String username, String identifier) {
        return userRepository.findEnrolmentStatus(username, identifier);
    }
    public CourseEnrolmentQueryResult enrollIn(String username, String identifier) {
        // Check if the user is already enrolled in the course
        Boolean alreadyEnrolled = userRepository.findEnrolmentStatus(username, identifier);
        if (alreadyEnrolled) {
            // If already enrolled, throw an exception
            throw new RuntimeException("User is already enrolled in the course");
        }

        // Create the enrolment relationship between the user and the course
        return userRepository.createEnrolmentRelationship(username, identifier);
    }



    public List<Course> getAllEnrolledCoursesByUsername(String username) {
        return courseRepository.findAllEnrolledCoursesByUsername(username);

    }
}
