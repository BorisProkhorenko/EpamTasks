package com.prokhorenko.serverSide;

import java.util.ArrayList;
import java.util.Objects;

public class Archive {

    private ArrayList<Student> students = new ArrayList<>();

    public Archive(ArrayList<Student> students) {
        this.students = students;
    }

    public Archive() {

    }

    public void addStudentFile(Student student) {
        student.setId(students.size()+1);
        students.add(student);
    }

    public void showStudentFiles() {
        for (Student student : students) {
            student.print();
            System.out.println("________________________________________________");
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Archive archive = (Archive) o;
        return Objects.equals(students, archive.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students);
    }

    @Override
    public String toString() {
        return "Archive{" +
                "dossiers=" + students +
                '}';
    }
}
