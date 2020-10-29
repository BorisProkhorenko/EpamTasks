package com.prokhorenko;

public class TextFile extends File {

    private String text;

    public TextFile(String name, Directory directory, String text) {
        super(name, directory);
        this.text = text;
    }

    public TextFile(String name, Directory directory) {
        super(name, directory);
        text = "";
    }

    @Override
    public TextFile createNewFile(String name, Directory directory) {
        return new TextFile(name, directory, text);
    }

    @Override
    public void print() {
        System.out.println(text);
    }


    public void delete() {
        text="";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addText(String addition){
        text = text + " " + addition;
    }

    @Override
    public String toString() {
        return "TextFile{" +
                "name='" + super.getName()+ '\'' +
                ", directory='" + super.getDirectory()+ '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
