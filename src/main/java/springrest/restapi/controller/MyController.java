package springrest.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springrest.restapi.entities.Course;
import springrest.restapi.services.CourseService;
import springrest.restapi.services.CourseServiceImpl;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    // Get courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //Adding a new course
    @PostMapping("/courses/add")
    public void addCourse(@RequestBody Course course){
        this.courseService.addCourse(course);
    }

    // Let's update the course
    @PutMapping("courses/update/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable Long id){
        this.courseService.updateCourse(course, id);
    }

}
