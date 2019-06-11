package test;
import Service.StudentService;
import Service.impl.MyBatisTestServiceImpl;
import Service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import selection.Validate;

public class test {
    @Autowired
     StudentServiceImpl studentService;
    public  void test(){
        studentService.test();
    }

    public static void main(String[] args) {


        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentServiceImpl = (StudentService) context.getBean("studentServiceImpl");
        studentServiceImpl.test();
//        MyBatisTestServiceImpl myBatisTestServiceImpl = (MyBatisTestServiceImpl) context.getBean("myBatisTestServiceImpl");
//        myBatisTestServiceImpl.test();

//        Calculator calculator = (Calculator) context.getBean("calculatorImpl");
//        double res=calculator.add(10,9);
//        System.out.println(res);

//        OperationServiceImpl operation = (OperationServiceImpl) context.getBean("operation");
//        System.out.println(operation.tryMyspringOperation("Abc"));
//        Student3 student3= (Student3) context.getBean("student3");
//        System.out.println(student3.toString());
//        Student3 studnet3= (Student3) context.getBean("Studnet3");
//        System.out.println(studnet3.toString());
//        Teacher teacher = (Teacher) context.getBean("teacher");
//        System.out.println(teacher.toString());

//        MyBatisTest test = (MyBatisTest) context.getBean("mybatisTree");
//        User user = (User)context.getBean("user");
//        Student student = (Student) context.getBean("student");
//        System.out.println(student.toString());
//
//
//        MySpringOperation operation = (MySpringOperation) context.getBean("lowerOperation");
//        System.out.println(operation.operate("java is No.1"));

//        try {
//            Class clazz=Class.forName("entity.User");
//            User user1=(User) clazz.newInstance();
//            clazz.getMethod("setName", String.class);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        CustomerWithBLOBs withBLOBs = new CustomerWithBLOBs();

//        查询user表的所有数据
//        MyBatisTest test = new MyBatisTest();
//        try {
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
//            test.dynamicForEachSql();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        //查询student表的所有数据
//        Student student = new Student();
//        try {
//            student.extude();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        WeekTest weekTest=new WeekTest();
//        try {
//            weekTest.queryClazz();
//            weekTest.queryStudent2();
//            weekTest.queryStudent();
//            weekTest.queryClazzAndStudent();
//            weekTest.queryStudentForJoint();
//            weekTest.queryClazzForJoint();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
