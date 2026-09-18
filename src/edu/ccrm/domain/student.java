package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class student extends person
{
    private String regno;
    private String status;


    private List<Enrollment> enrollments;
    private LocalDate creationDate;




    public student(int id, String name, String email, String regno) {
        super(id, name, email);
        this.regno = regno;
        this.status = "active";
        this.creationDate = LocalDate.now();
        this.enrollments = new ArrayList<>();
    }


    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }


    public String getInfo() {
        return "student{" +
                "id=" + id +
                ", regno='" + regno + '\'' +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", enrollments=" + enrollments +
                ", creationDate=" + creationDate +
                '}';
    }

}
