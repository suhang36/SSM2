package Service.impl;

import Dao.StudentDao;
import Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.naming.Context;
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public void test() {
        System.out.println("---------------------------------------------------");
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao=null;
        {
            studentDao = (StudentDao) context.getBean("studentDao");
        }
        System.out.println(studentDao.select());
        System.out.println("---------------------------------------------------");
    }
}
