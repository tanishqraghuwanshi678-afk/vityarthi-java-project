# Campus Course & Records Manager (CCRM)

A lightweight, in-memory **Course and Student Management System** built in Java. CCRM lets you manage students, courses, instructors, enrollments, and grades through a clean, domain-driven design — no database required.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Architecture](#architecture)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Usage Examples](#usage-examples)
- [Domain Model](#domain-model)
- [Design Patterns Used](#design-patterns-used)
- [Roadmap](#roadmap)

## Overview

CCRM (Campus Course & Records Manager) is a simple yet extensible Java application for handling core academic record-keeping tasks: enrolling students in courses, tracking grades, and managing instructors — all in memory, making it ideal for learning object-oriented design, the builder pattern, and service-layer architecture.

## Features

- **Student Management** — Add, update, retrieve, and list students
- **Course Management** — Create and manage courses using a builder pattern
- **Enrollment System** — Enroll students in courses and track their academic progress
- **Instructor Assignment** — Assign instructors to courses
- **Grade Tracking** — Record and retrieve grades via a structured `Grades` enum
- **Custom Search & Filters** — Query courses using flexible, composable filters
- **Semester Support** — Organize courses by semester (Enum-based)
- **Domain-Driven Design** — Clear separation between domain models and services

## Project Structure

```
vityarthi-java-project/
├── Main.java                          # Application entry point
└── edu/
    └── ccrm/
        ├── domain/                    # Core domain models
        │   ├── Course.java            # Course entity (Builder pattern)
        │   ├── Enrollment.java        # Student-course enrollment record
        │   ├── Grades.java            # Enum of possible grade values
        │   ├── Instructor.java        # Instructor entity
        │   ├── Person.java            # Abstract base class for people
        │   ├── Semester.java          # Enum for academic semesters
        │   └── Student.java           # Student entity
        └── service/                   # Business logic / service layer
            ├── CourseService.java     # Course management operations
            └── StudentService.java    # Student management operations
```

## Architecture

CCRM follows a simple **layered, domain-driven architecture**:

| Layer | Responsibility |
|---|---|
| **Domain** | Plain entities (`Student`, `Course`, `Instructor`, etc.) that model real-world academic concepts |
| **Service** | Business logic — creating, updating, searching, and linking domain objects |
| **Main** | Application entry point that wires everything together |

`Person` acts as an abstract base class, with `Student` and `Instructor` inheriting shared attributes such as name and ID — keeping the domain model DRY and consistent.

## Prerequisites

- **Java Development Kit (JDK) 8 or higher** installed and available on your `PATH`
- Verify your installation:
  ```sh
  java -version
  javac -version
  ```

## Getting Started

### 1. Clone the repository

```sh
git clone https://github.com/<tanishqraghuwanshi678-afk>/vityarthi-java-project.git
cd vityarthi-java-project
```

### 2. Compile the project

```sh
javac Main.java edu/ccrm/domain/*.java edu/ccrm/service/*.java
```

### 3. Run the application

```sh
java Main
```

> **Tip:** If you're using an IDE (IntelliJ IDEA, Eclipse, or VS Code with the Java extension), simply import the project as a Java project and run `Main.java` directly.

## Usage Examples

Here's a conceptual example of how the services might be used within `Main.java`:

```java
StudentService studentService = new StudentService();
CourseService courseService = new CourseService();

// Add a new student
Student student = new Student("S001", "Aditi Sharma");
studentService.addStudent(student);

// Build a course using the builder pattern
Course course = new Course.Builder()
        .courseId("CSE101")
        .title("Introduction to Programming")
        .credits(4)
        .semester(Semester.FALL)
        .build();
courseService.addCourse(course);

// Enroll the student in the course
Enrollment enrollment = new Enrollment(student, course);
studentService.enroll(enrollment);

// Assign a grade
enrollment.setGrade(Grades.A);
```

> Note: Adapt method names to match your actual service implementations if they differ.

## Domain Model

| Class | Description |
|---|---|
| `Person` | Abstract base class holding common attributes (name, ID) shared by students and instructors |
| `Student` | Represents a student, extends `Person` |
| `Instructor` | Represents a course instructor, extends `Person` |
| `Course` | Represents a course, built using the Builder pattern |
| `Enrollment` | Links a `Student` to a `Course`, holding grade information |
| `Grades` | Enum representing possible letter grades (e.g., `A`, `B`, `C`, `D`, `F`) |
| `Semester` | Enum representing academic semesters (e.g., `SPRING`, `FALL`) |

## Design Patterns Used

- **Builder Pattern** — Used in `Course.java` for cleanly constructing course objects with multiple optional fields
- **Abstraction & Inheritance** — `Person` as an abstract superclass for `Student` and `Instructor`
- **Service Layer Pattern** — Business logic is decoupled from domain models via dedicated service classes
- **Enums for Fixed Value Sets** — `Grades` and `Semester` model constrained sets of values in a type-safe way

## Roadmap

- [ ] Persist data to a file or database (currently in-memory only)
- [ ] Add unit tests (JUnit)
- [ ] Add a CLI menu for interactive use
- [ ] Support GPA calculation
- [ ] Add input validation and custom exceptions
- [ ] Package as a Maven/Gradle project for dependency management
