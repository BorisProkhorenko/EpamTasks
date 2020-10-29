package com.prokhorenko;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Notebook {
    private ArrayList<Note> notes = new ArrayList<>();

    public boolean match(String enteredString, String sourceString) {
        Pattern pattern = Pattern.compile(enteredString);
        Matcher matcher = pattern.matcher(sourceString);
        if (matcher.find()) {
            return true;
        } else return false;
    }

    public ArrayList<Note> customSearch(String enteredString, boolean themeSearch, boolean dateSearch,
                                        boolean eMailSearch, boolean messageSearch) {
        ArrayList<Note> noteList = new ArrayList<>();
        for (Note note : notes) {
            String sourceString = "";

            if (themeSearch)
                sourceString += note.getSubject();
            if (dateSearch)
                sourceString += note.getDate();
            if (eMailSearch)
                sourceString += note.getMail();
            if (messageSearch)
                sourceString += note.getMessage();

            if (match(enteredString, sourceString)) {
                noteList.add(note);
            }
        }
        return noteList;
    }

    public LinkedList<Note> searchEverywhere(String enteredString) {
        LinkedList<Note> noteList = new LinkedList<>();
        for (Note note : notes) {
            String sourceString = note.getSubject() + note.getDate() + note.getMail() + note.getMessage();
            if (match(enteredString, sourceString)) {
                noteList.add(note);
            }
        }
        return noteList;
    }


    public LinkedList<Note> searchByTheme(String enteredString) {
        LinkedList<Note> noteList = new LinkedList<>();
        for (Note note : notes) {
            String sourceString = note.getSubject();
            if (match(enteredString, sourceString)) {
                noteList.add(note);
            }
        }
        return noteList;
    }

    public LinkedList<Note> searchByDate(String enteredString) {
        LinkedList<Note> noteList = new LinkedList<>();
        for (Note note : notes) {
            String sourceString = note.getDate();
            if (match(enteredString, sourceString)) {
                noteList.add(note);
            }
        }
        return noteList;
    }

    public LinkedList<Note> searchByMail(String enteredString) {
        LinkedList<Note> noteList = new LinkedList<>();
        for (Note note : notes) {
            String sourceString = note.getMail();
            if (match(enteredString, sourceString)) {
                noteList.add(note);
            }
        }
        return noteList;
    }

    public LinkedList<Note> searchByMessage(String enteredString) {
        LinkedList<Note> noteList = new LinkedList<>();
        for (Note note : notes) {
            String sourceString = note.getMessage();
            if (match(enteredString, sourceString)) {
                noteList.add(note);
            }
        }
        return noteList;
    }

    public void createNote(String subject, String date, String eMail, String message) {
        if (!dateCheck(date)) {
            System.out.println("Incorrect date");
            return;
        }
        if (!mailCheck(eMail)) {
            System.out.println("Incorrect e-mail");
            return;
        }
        notes.add(new Note(subject, date, eMail, message));
    }

    public void createNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter subject");
        String theme = scanner.nextLine();
        System.out.println("Enter date in DD-MM-YYYY format");
        String date = scanner.nextLine();
        if (!dateCheck(date)) {
            System.out.println("Incorrect date");
            return;
        }
        System.out.println("Enter e-mail");
        String mail = scanner.nextLine();
        if (!mailCheck(mail)) {
            System.out.println("Incorrect e-mail");
            return;
        }
        System.out.println("Enter message");
        String message = scanner.nextLine();
        notes.add(new Note(theme, date, mail, message));
    }

    public boolean dateCheck(String date) {
        if (date.matches("(([12]\\d{1})|(0[123456789]{1})|(3[01]{1}))-((0[123456789]{1})|(1[012]))-\\d{4}"))
            return true;
        else return false;
    }

    public boolean mailCheck(String mail) {
        if (mail.matches("\\w+@\\w+\\.\\D{2,12}"))
            return true;
        else return false;
    }

    public void reWriteNotes() {
        String line = "";
        for (Note note : notes) {
            line += note.getSubject() + "|" +
                    note.getDate() + "|" +
                    note.getMail() + "|" +
                    note.getMessage() + "\n";

        }
        try {
            FileWriter fw = new FileWriter(new File("").getAbsolutePath() +
                    "\\src\\com\\prokhorenko\\resources\\notes", false);
            fw.append(line);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return Objects.equals(notes, notebook.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notes);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "notes=" + notes +
                '}';
    }
}
