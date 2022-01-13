package springrest.restapi.services;

import springrest.restapi.entities.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();

    public Course getCourse(long courseId);

    void addCourse(Course course);

    void updateCourse(Course course, Long id);
}
