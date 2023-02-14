package edu.sabanciuniv.model;

import jakarta.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor {
    // variables
    private int fixedSalary;

    //constructors
    public PermanentInstructor(String fullName, String personalAddress, String phoneNumber, int fixedSalary) {
        super(fullName, personalAddress, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor() {
    }

    //getter setter
    public int getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public String toString() {
        return " Visiting Researcher{" +
                "fullName='" + this.getFullName() + '\'' +
                ", personalAddress='" + this.getPersonalAddress() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                ", fixedSalary='" + this.getFixedSalary() + '\'' +
                '}';
    }
}
