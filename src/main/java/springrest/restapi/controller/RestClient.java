package springrest.restapi.controller;


import org.apache.catalina.User;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import springrest.restapi.entities.Course;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RestClient {
    public static final String GET_COURSES = "http://localhost:9090/courses";
    public static final String GET_COURSE_BY_ID = "http://localhost:9090/courses/{courseId}";
    public static final String UPDATE_COURSE = "http://localhost:9090/courses/update/{id}";
    public static final String ADD_COURSE = "http://localhost:9090/courses/add";

    static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        getCourses();
        getCourseById();
        updateCourseById();
        getCourses();
    }

    // Getting all courses name using exchange API.
    private static void getCourses(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> result = restTemplate.exchange(GET_COURSES, HttpMethod.GET, entity, String.class);
        System.out.println(result);
    }

    // Getting a single course using getForObject using courseId.
    private static void getCourseById(){
        Map<String, Integer> param = new HashMap<>();
        param.put("courseId", 1);
        Course course = restTemplate.getForObject(GET_COURSE_BY_ID, Course.class, param);
        System.out.println(course.getTitle());
        System.out.println(course.getDescription());
    }

    private static void updateCourseById(){
        Map<String, Integer> param = new HashMap<>();
        param.put("id", 2);
        Course updateNewCourse = new Course(2, "New title", "This is the desc");
        restTemplate.put(UPDATE_COURSE, updateNewCourse, param);
    }
}
