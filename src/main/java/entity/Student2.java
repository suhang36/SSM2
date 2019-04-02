package entity;

public class Student2 {
    private String no;
    private String name;
    private Clazz clazz;

    @Override
    public String toString() {
        return "Student2{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
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

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
