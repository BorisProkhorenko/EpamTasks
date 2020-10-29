package com.prokhorenko;

public abstract class File {
    private String name;
    private Directory directory;

    public File(String name, Directory directory) {
        this.name = name;
        this.directory = directory;
    }

    public abstract File createNewFile(String name, Directory directory);

    public abstract void print();

    public abstract void delete();


    public void rename(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", directory=" + directory +
                '}';
    }
}
