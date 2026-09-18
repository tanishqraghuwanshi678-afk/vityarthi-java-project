# vityarthi-java-project
# Course & Student Management System

This Java project provides a simple in-memory system for managing students, courses, enrollments, instructors, and grades. It is organized using domain-driven design principles.

## Project Structure

- **Main.java**: Entry point for the application.
- **edu/ccrm/domain/**: Domain models.
  - `Course.java`: Course entity with builder pattern.
  - `Enrollment.java`: Represents student enrollment in a course.
  - `grades.java`: Enum for grade values.
  - `instructor.java`: Instructor entity.
  - `person.java`: Abstract base class for people.
  - `semester.java`: Enum for semesters.
  - `student.java`: Student entity.
- **edu/ccrm/service/**: Service classes.
  - `CourseService.java`: Manages courses.
  - `StudentService.java`: Manages students.

## How to Run

1. Compile all `.java` files:
    ```sh
    javac Main.java edu/ccrm/domain/*.java edu/ccrm/service/*.java
    ```
2. Run the main class:
    ```sh
    java Main
    ```

## Features

- Add, update, and retrieve students and courses.
- Enroll students in courses.
- Assign grades and instructors.
- Search courses using custom filters.

## Notes

- All data is stored in memory (no database).
- Extend domain and service classes for more features.

## License

MIT License (add your own if needed)
