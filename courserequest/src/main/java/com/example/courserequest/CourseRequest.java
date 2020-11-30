package com.example.courserequest;

public class CourseRequest {
    private Long userId;
    private Course course;

    public CourseRequest() {
    }

    public CourseRequest(Long userId, Course course) {
        this.userId = userId;
        this.course = course;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseRequest{" +
                "userId='" + userId + '\'' +
                ", course=" + course +
                '}';
    }
}
