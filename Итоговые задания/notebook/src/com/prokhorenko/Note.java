package com.prokhorenko;

import java.util.Objects;

public class Note implements Comparable<Note> {

    private String subject;
    private String date;
    private String eMail;
    private String message;

    public Note(String subject, String date, String eMail, String message) {
        this.subject = subject;
        this.date = date;
        this.eMail = eMail;
        this.message = message;
    }

    public void print() {
        System.out.println("Subject: " + subject + "\nDate: " + date + "\ne-mail: " + eMail + "\n" + message);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMail() {
        return eMail;
    }

    public void setMail(String eMail) {
        this.eMail = eMail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int compareTo(Note o) {
        return this.getDate().compareTo(o.getDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(subject, note.subject) &&
                Objects.equals(date, note.date) &&
                Objects.equals(eMail, note.eMail) &&
                Objects.equals(message, note.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, date, eMail, message);
    }

    @Override
    public String toString() {
        return "Note{" +
                "subject='" + subject + '\'' +
                ", date='" + date + '\'' +
                ", eMail='" + eMail + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


}
