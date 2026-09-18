package edu.ccrm.service;


import edu.ccrm.domain.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class CourseService {
    private List<Course> courses = new ArrayList<>();
    CourseService() {};

    public Course addCourse(Course course) {
        for (Course existingCourse : courses) {
            if (existingCourse.getCode().equals(course.getCode())) {
                throw new IllegalArgumentException("A course with code '" + course.getCode() + "' already exists.");
            }
        }
        courses.add(course);
        System.out.println("SUCCESS: Added course -> " + course.getTitle());
        return course;
    }
    public Course getCourseByCode(String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code)){
                return course;
            }
        }
        return null;
    }
    public List<Course> searchCourse(Predicate<Course> filter)
    {
        return courses.stream().filter(filter).collect(Collectors.toList());

    }




}
