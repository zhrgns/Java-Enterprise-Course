package edu.sabanciuniv.model;

import jakarta.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor {
    //variables
    private int hourlySalary;

    //constructor
    public VisitingResearcher() {
    }

    public VisitingResearcher(String fullName, String personalAddress, String phoneNumber, int hourlySalary) {
        super(fullName, personalAddress, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    //getter setter
    public int getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return " Visiting Researcher{" +
                "fullName='" + this.getFullName() + '\'' +
                ", personalAddress='" + this.getPersonalAddress() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                ", hourlySalary='" + this.getHourlySalary() + '\'' +
                '}';
    }
}
