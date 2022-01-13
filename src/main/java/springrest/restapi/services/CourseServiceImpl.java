package springrest.restapi.services;

import org.springframework.stereotype.Service;
import springrest.restapi.entities.Course;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    List<Course> list;
    public CourseServiceImpl() {
        list = new ArrayList<>();
        list.add(new Course(1, "Java spring boot", "Building restfull api's"));
        list.add(new Course(2, "New course", "Just a random course"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        Course c = null;
        for(Course course: list){

            if(course.getId() == courseId){
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public void addCourse(Course course) {
        list.add(course);
    }

    @Override
    public void updateCourse(Course course, Long id) {
        for(Course c: list){
            if(c.getId() == id){
                c.setTitle(course.getTitle());
                c.setDescription(course.getDescription());
            }
        }
    }
}
