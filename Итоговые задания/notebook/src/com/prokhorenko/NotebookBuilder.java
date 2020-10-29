package com.prokhorenko;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NotebookBuilder {

    private String notesFilePath;

    public NotebookBuilder() {
        notesFilePath = new File("").getAbsolutePath() +
                "\\src\\com\\prokhorenko\\resources\\notes";
    }

    public NotebookBuilder(String notesFilePath) {
        this.notesFilePath = notesFilePath;
    }

    public Notebook buildNotebook() {
        Notebook notebook = new Notebook();
        notebook.setNotes(parseNotes(readData(notesFilePath)));
        return notebook;

    }

    private ArrayList<Note> parseNotes(String[] notesData) {
        ArrayList<Note> notesArrayList = new ArrayList<>();
        int id = 1;
        for (String line : notesData) {
            String[] parameters = line.split("\\|");
            notesArrayList.add(new Note(parameters[0], parameters[1], parameters[2], parameters[3]));
        }
        return notesArrayList;
    }

    private String[] readData(String filePath) {

        String line;
        ArrayList<String> data = new ArrayList<>();

        try (FileReader inputStream = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(inputStream)) {
            while ((line = reader.readLine()) != null && !line.equals("")) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toArray(new String[0]);
    }

    public String getNotesFilePath() {
        return notesFilePath;
    }

    public void setNotesFilePath(String notesFilePath) {
        this.notesFilePath = notesFilePath;
    }
}
