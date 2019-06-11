package Dao;

import entity.Clazz;
import entity.Student2;

import java.util.List;

public interface Customer {
    public List<Clazz> queryClazz(Clazz clazz);
    public List<Student2> queryStudent2(Student2 student2);
    public List<Student2> queryStudent(Student2 student2);
    public List<Clazz> queryClazzAndStudent(Clazz clazz);
    public List<Student2> queryStudentForJoint(Student2 student2);
    public List<Clazz> queryClazzForJoint(Clazz clazz);
}
