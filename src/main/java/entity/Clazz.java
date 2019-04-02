package entity;

import java.util.List;

public class Clazz {
    private String no;
    private String name;
    private List<Student2> student2s;

    @Override
    public String toString() {
        return "Clazz{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", student2s=" + student2s +
                '}';
    }

    public List<Student2> getStudent2s() {
        return student2s;
    }
    public void setStudent2s(List<Student2> student2s) {
        this.student2s = student2s;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
