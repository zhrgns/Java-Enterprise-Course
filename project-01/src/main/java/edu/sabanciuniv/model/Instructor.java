package edu.sabanciuniv.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Instructor {
    //variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String personalAddress;
    private String phoneNumber;

    @OneToMany(mappedBy = "courseInstructor")
    private List<Course> courseList = new ArrayList<>();

    //constructor
    public Instructor(String fullName, String personalAddress, String phoneNumber) {
        this.fullName = fullName;
        this.personalAddress = personalAddress;
        this.phoneNumber = phoneNumber;
    }

    public Instructor() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    //to string
    @Override
    public String toString() {
        return "Instructor{" +
                "fullName='" + this.fullName + '\'' +
                ", personalAddress='" + this.personalAddress + '\'' +
                ", phoneNumber='" + this.phoneNumber + '\'' +
                '}';
    }
}
