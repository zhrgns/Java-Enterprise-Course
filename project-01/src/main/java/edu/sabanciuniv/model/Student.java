package edu.sabanciuniv.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {
    //variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String personalAddress;
    private LocalDate birthDate;
    private String gender;
    private String emailAddress;

    // student can have many course! course can have many students
    @ManyToMany
    private List<Course> studentCourses = new ArrayList<>();

    //constructors
    public Student() {
    }

    public Student(String fullName, String personalAddress, LocalDate birthDate, String gender, String emailAddress) {
        this.fullName = fullName;
        this.personalAddress = personalAddress;
        this.birthDate = birthDate;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    //getter setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPersonalAddress() {
        return personalAddress;
    }

    public void setPersonalAddress(String personalAddress) {
        this.personalAddress = personalAddress;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Course> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<Course> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    //toString, equals, hashCode


    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", personalAddress='" + personalAddress + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!Objects.equals(fullName, student.fullName)) return false;
        return Objects.equals(emailAddress, student.emailAddress);
    }

    @Override
    public int hashCode() {
        int result = fullName != null ? fullName.hashCode() : 0;
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        return result;
    }
}

