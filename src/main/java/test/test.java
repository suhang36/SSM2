package test;

import entity.Customer;
import entity.CustomerWithBLOBs;
import work.Student;

public class test {
    public static void main(String[] args) {

        CustomerWithBLOBs withBLOBs = new CustomerWithBLOBs();

//        查询user表的所有数据
        MyBatisTest test = new MyBatisTest();
        try {
//            test.queryForParam();
//            test.queryForAll();
//            test.queryForClass();
//            test.insertUser();
//            test.queryForUser();
//            test.indertUser1();
//            test.updateUser();
//            test.testSW();
//            test.updateUser();
//            test.selUser();
//            test.selStudent2();
//            test.bynamicUpdateSql();
            test.dynamicForEachSql();
        }catch (Exception e){
            e.printStackTrace();
        }
//        //查询student表的所有数据
//        Student student = new Student();
//        try {
//            student.extude();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}