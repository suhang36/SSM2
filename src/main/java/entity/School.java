package entity;

public class School {
    private String driver;
    private String schoolName;
    private String id;

    @Override
    public String toString() {
        return "School{" +
                "driver='" + driver + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
