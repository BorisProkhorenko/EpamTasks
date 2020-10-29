package com.prokhorenko.serverSide;



import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class User {
    private String username;
    private String password;
    private Archive archive;

    public User(String username, String password, Archive archive) {
        this.username = username;
        this.password = password;
        this.archive = archive;
    }

    public User() {
    }

    public boolean match(String enteredString, String sourceString) {
        Pattern pattern = Pattern.compile(enteredString);
        Matcher matcher = pattern.matcher(sourceString);
        if (matcher.find()) {
            return true;
        } else return false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(archive, user.archive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, archive);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", archive=" + archive +
                '}';
    }
}
