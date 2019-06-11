package Dao.impl;

import Dao.Customer;
import entity.Clazz;
import entity.Student2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Repository
public class WeekTest {
    private final Logger LOGGER=Logger.getLogger(this.getClass());
    Map<String,Object> params = null;
    InputStream input=null;
    SqlSessionFactory build;
    SqlSession sqlSession;
    Customer mapper;
    {
        try {
            input = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        build = new SqlSessionFactoryBuilder().build(input);
        sqlSession=build.openSession();
        mapper = sqlSession.getMapper(Customer.class);
    }
    public void queryClazz(){
        System.out.println("根据no和name查询clazz表中信息");
        Clazz clazz = new Clazz();
        clazz.setNo("1");
        System.out.println();
        List<Clazz> clazzs;
        clazzs = mapper.queryClazz(clazz);
        clazzs.forEach(System.out::println);
    }
    public void queryStudent2(){
        System.out.println("根据no和name查询Student表中信息");
        Student2 student2 = new Student2();
        student2.setNo("1");
        List<Student2> student2s = mapper.queryStudent2(student2);
        student2s.forEach(System.out::println);
    }

    public void queryStudent(){
        System.out.println("根据no和name查询student表中信息，并将clazz信息查询出来（1:1）(子查询)");
        Student2 student2 = new Student2();
        student2.setNo("1");
        List<Student2> student2s = mapper.queryStudent(student2);
        student2s.forEach(System.out::println);
    }
    public void queryClazzAndStudent(){
        System.out.println("根据name查询clazz信息，并将student信息查询出来（1:n）(子查询)");
        Clazz clazz = new Clazz();
        clazz.setNo("1");
        System.out.println();
        List<Clazz> clazzs;
        clazzs = mapper.queryClazzAndStudent(clazz);
        clazzs.forEach(System.out::println);
    }

    public void queryStudentForJoint(){
        System.out.println("根据no和name查询student表中信息，并将clazz信息查询出来（1:1）（联合查询");
        Student2 student2 = new Student2();
        student2.setNo("1");
        List<Student2> student2s = mapper.queryStudentForJoint(student2);
        student2s.forEach(System.out::println);
    }
    public void queryClazzForJoint(){
        System.out.println("根据name查询clazz信息，并将student信息查询出来（1:n)(联合查询）");
        Clazz clazz = new Clazz();
        clazz.setNo("1");
        System.out.println();
        List<Clazz> clazzs;
        clazzs = mapper.queryClazzForJoint(clazz);
        clazzs.forEach(System.out::println);
    }
}
