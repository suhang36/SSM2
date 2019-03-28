package entity;

import java.util.List;

public class Student {
    private String id;
    private List<User> users;
    private String school;
    private String classes;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", users=" + users +
                ", school='" + school + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
