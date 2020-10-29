package com.prokhorenko.serverSide;


import java.util.Objects;


public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private String faculty;
    private int groupNumber;
    private int yearOfEnrollment;

    public Student(String name, String faculty, int groupNumber, int yearOfEnrollment) {
        id = 0;
        this.name = name;
        this.faculty = faculty;
        this.groupNumber = groupNumber;
        this.yearOfEnrollment = yearOfEnrollment;
    }

    public Student() {
    }

    public void print() {
        System.out.println("id:" + id + "\nName: " + name + "\nFaculty: " +
                faculty + "\nGroup number: " + groupNumber + "\nThe year of Enrollment: " + yearOfEnrollment);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    public void setYearOfEnrollment(int yearOfEnrollment) {
        this.yearOfEnrollment = yearOfEnrollment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                groupNumber == student.groupNumber &&
                yearOfEnrollment == student.yearOfEnrollment &&
                Objects.equals(name, student.name) &&
                Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, faculty, groupNumber, yearOfEnrollment);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", groupNumber=" + groupNumber +
                ", yearOfEnrollment=" + yearOfEnrollment +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        return id - o.id;
    }
}
