package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Student3 {
    private String name;
    private int sex;
    private String birthday;
    private String studyNo;
    @Autowired
    private Teacher teacher;

    @Override
    public String toString() {
        return "Student3{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday='" + birthday + '\'' +
                ", studyNo='" + studyNo + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStudyNo() {
        return studyNo;
    }

    public void setStudyNo(String studyNo) {
        this.studyNo = studyNo;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
