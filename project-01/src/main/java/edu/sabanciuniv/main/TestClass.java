package edu.sabanciuniv.main;

import edu.sabanciuniv.model.*;
import edu.sabanciuniv.utility.EntityManagerUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        saveTestData();
    }

    private static void saveTestData() {
        //create student objects
        Student student1 = new Student("Zehra Gunes", "Altunizade", LocalDate.of(1994, Month.OCTOBER, 25), "Female", "zgunes@sabanciuniv.edu");
        Student student2 = new Student("Selman Gunes", "Maslak", LocalDate.of(1998, Month.MARCH, 5), "Male", "sgunes@itu.edu");

        //create course objects
        Course course1 = new Course("Java", 1200, 3);
        Course course2 = new Course("SQL", 1300, 3);

        //create instructor objects
        Instructor instructor1 = new PermanentInstructor("A.Demirelli","Tuzla", "05455455454",12345);
        Instructor instructor2 = new VisitingResearcher("U.Koc","Altunizade","05432231313",12345);

        //set course instructors
        course1.setCourseInstructor(instructor1);
        course2.setCourseInstructor(instructor2);

        //set instructor's courseList
        instructor1.getCourseList().add(course1);
        instructor2.getCourseList().add(course2);

        //enroll students to courses
        course1.getStudentList().add(student1);
        course2.getStudentList().add(student1);

        course1.getStudentList().add(student2);
        course2.getStudentList().add(student2);

        //add courses to students courseList
        student1.getStudentCourses().add(course1);
        student1.getStudentCourses().add(course2);
        student2.getStudentCourses().add(course2);
        student2.getStudentCourses().add(course2);

        //create em and emf
        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

        //insert values to table
        try {
            entityManager.getTransaction().begin();

            //add students
            entityManager.persist(student1);
            entityManager.persist(student2);

            //add courses
            entityManager.persist(course1);
            entityManager.persist(course2);

            //add instructors
            entityManager.persist(instructor1);
            entityManager.persist(instructor2);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("Changes are not committed " + e.getMessage());
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }
}

