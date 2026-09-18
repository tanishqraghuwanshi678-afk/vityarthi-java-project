import edu.ccrm.domain.Course;
import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.grades;
import edu.ccrm.domain.instructor;
import edu.ccrm.domain.semester;
import edu.ccrm.domain.student;
import edu.ccrm.service.CourseService;
import edu.ccrm.service.StudentService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   COURSE & STUDENT MANAGEMENT SYSTEM");
        System.out.println("========================================\n");

        // Create services
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();

        // ----------------------------------------
        // 1. CREATE STUDENTS
        // ----------------------------------------

        student s1 = studentService.addStudent(
                "Rahul Sharma",
                "rahul@example.com",
                "23BCE1001"
        );

        student s2 = studentService.addStudent(
                "Priya Singh",
                "priya@example.com",
                "23BCE1002"
        );

        System.out.println("\n--- Students ---");

        for (student s : studentService.getAllStudents()) {
            System.out.println(s.getInfo());
        }

        // ----------------------------------------
        // 2. CREATE INSTRUCTOR
        // ----------------------------------------

        instructor instructor1 = new instructor(
                101,
                "Dr. Amit Kumar",
                "amit@example.com",
                "Computer Science",
                "Artificial Intelligence"
        );

        // ----------------------------------------
        // 3. CREATE COURSES
        // ----------------------------------------

        Course course1 = new Course.CourseBuilder(
                "CS101",
                "Introduction to Programming"
        )
                .withCredits(4)
                .withDepartment("Computer Science")
                .withInstructor(instructor1)
                .withSemester(semester.Fall)
                .build();

        Course course2 = new Course.CourseBuilder(
                "AI201",
                "Artificial Intelligence"
        )
                .withCredits(3)
                .withDepartment("Computer Science")
                .withInstructor(instructor1)
                .withSemester(semester.Fall)
                .build();

        courseService.addCourse(course1);
        courseService.addCourse(course2);

        System.out.println("\n--- Courses ---");

        System.out.println(courseService.getCourseByCode("CS101"));
        System.out.println(courseService.getCourseByCode("AI201"));

        // ----------------------------------------
        // 4. ENROLL STUDENTS IN COURSES
        // ----------------------------------------

        Enrollment e1 = new Enrollment(s1, course1);
        e1.setGrade(grades.A);

        Enrollment e2 = new Enrollment(s2, course1);
        e2.setGrade(grades.S);

        s1.getEnrollments().add(e1);
        s2.getEnrollments().add(e2);

        System.out.println("\n--- Enrollments ---");

        System.out.println(e1);
        System.out.println(e2);

        // ----------------------------------------
        // 5. SEARCH COURSES
        // ----------------------------------------

        System.out.println("\n--- Search Course ---");

        List<Course> csCourses = courseService.searchCourse(
                course -> course.getDepartment()
                        .equalsIgnoreCase("Computer Science")
        );

        for (Course course : csCourses) {
            System.out.println(course);
        }

        // ----------------------------------------
        // 6. FIND STUDENT
        // ----------------------------------------

        System.out.println("\n--- Student Lookup ---");

        student found = studentService.findStudentByRegNo("23BCE1001");

        if (found != null) {
            System.out.println("Found student: " + found.getName());
        }

        // ----------------------------------------
        // END
        // ----------------------------------------

        System.out.println("\n========================================");
        System.out.println("          PROGRAM COMPLETED");
        System.out.println("========================================");
    }
}
