package com.prokhorenko;


public class Directory {
    private String name;
    private String path;

    public Directory(String name, String path) {
        this.name = name;
        this.path = path + "\\" + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
