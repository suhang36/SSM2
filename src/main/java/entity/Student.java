package entity;

import java.util.List;
import java.util.SortedSet;

public class Student {
    private String id;

    private String school;
    private String classes;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
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
