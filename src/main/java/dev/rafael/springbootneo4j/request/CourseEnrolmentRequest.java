package dev.rafael.springbootneo4j.request;

public class CourseEnrolmentRequest {

    private String courseIdentifier;

    public CourseEnrolmentRequest() {
    }

    public String getCourseIdentifier() {
        return courseIdentifier;
    }

    public void setCourseIdentifier( String courseIdentifier ) {
        this.courseIdentifier = courseIdentifier;
    }
}
