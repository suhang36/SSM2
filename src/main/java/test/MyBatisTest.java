package test;

import entity.Student;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    private final Logger LOGGER=Logger.getLogger(this.getClass());
    Map<String,Object> params = null;
    InputStream input=null;
    SqlSessionFactory build;
    SqlSession sqlSession;
    {
        try {
            input = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        build = new SqlSessionFactoryBuilder().build(input);
    }
    public void queryForParam() {
        LOGGER.info("开始执行queryForParam方法");
        params=new HashMap<>();
        params.put("name","苏航");
        params.put("password","123456");
        sqlSession = build.openSession();
        List<Map> list = sqlSession.selectList("findUserParameter",params);
        System.out.println("list = " + list);
    }
    public void queryForAll(){
        LOGGER.info("开始执行queryForAll方法");
        sqlSession = build.openSession();
        List<Map> list = sqlSession.selectList("findUser","苏航");
        System.out.println("list = " + list);
        sqlSession.close();
    }
    public void queryForClass(){
        User user = new User();
        user.setName("苏航");
        user.setPassword("123456");
        sqlSession = build.openSession();
        List<Object> list = sqlSession.selectList("findClass", user);
        System.out.println(list);
        sqlSession.close();
    }

    public void queryForUser(){
        User user = new User();
        user.setName("苏航");
        user.setPassword("123456");
        List<User> users = null;
        sqlSession = build.openSession();
        try {
            users = sqlSession.selectList("findClassForUser", user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        for (User u : users) {
            System.out.println("name:  " + u.getName()+"  password:   "+u.getPassword());
        }

    }

    public void insertUser(){
        User user = new User();
        user.setName("苏航");
        user.setPassword("123456");
        sqlSession = build.openSession(true);
        sqlSession.insert("insertUser",user);
        sqlSession.close();
    }

    public int indertUser1(){
        User user = new User();
        user.setName("su");
        user.setPassword("123456");
        sqlSession = build.openSession(true);
        int insert = sqlSession.insert("UserMapper.insertUser1", user);
        sqlSession.close();
        LOGGER.info("受影响的条数"+insert);
        return insert;
    }
    public void updateUser(){
        User user = new User();
        user.setId(6);
        user.setName("su");
        user.setPassword("234567");
        sqlSession = build.openSession(true);
        int insert = sqlSession.insert("UserMapper.updateUser", user);
        sqlSession.close();
        LOGGER.info("受影响的条数"+insert);
    }
    public void  delUser(){
        User user = new User();
        user.setId(6);
        user.setName("su");
        user.setPassword("234567");
        int insert;
        sqlSession = build.openSession(true);
        insert = sqlSession.delete("UserMapper.delUser", user);
        sqlSession.close();
        sqlSession.commit();
        LOGGER.info("受影响的条数"+insert);
    }

    public void testSW(){
        User user;
        user = new User();
        user.setId(6);
        user.setName("su");
        user.setPassword("234567");
        sqlSession = build.openSession();
        try {
            sqlSession.insert("UserMapper.insertUser1",user);
            sqlSession.delete("UserMapper.delUser",user);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    public void selUser(){
        sqlSession = build.openSession();
        List<User> users = null;
        User user = new User();
        user.setName("su");
        try {
            users = sqlSession.selectList("selectUser",user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        for (User user1 : users) {
            System.out.println("user1 = " + user1.toString());
        }
    }
    public void selStudent(){
        sqlSession = build.openSession();
        List<Student> list = null;
        try {
            list = sqlSession.selectList("unionUser");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        System.out.println(list.get(0).toString());
    }

    public void selStudent2(){
        sqlSession = build.openSession();
        List<Student> list = null;
        try {
            list = sqlSession.selectList("selectStudent3",1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        System.out.println(list.get(0).toString());
    }

    public void dynamicIfSql(){
        sqlSession = build.openSession();
        User user = new User();
        user.setName("su");
        user.setPassword("123456");
        List<User> list = null;
        try {
            list = sqlSession.selectList("dynamicIfSql",user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        for (User user1 : list) {
            System.out.println(user1.toString());
        }
    }
    public void dynamicIfSql2(){
        sqlSession = build.openSession();
        User user = new User();
        user.setName("su");
        List<User> list = null;
        try {
            list = sqlSession.selectList("dynamicIfSql2",user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        for (User user1 : list) {
            System.out.println(user1.toString());
        }
    }

    public void dynamicIfSql3(){
        sqlSession = build.openSession();
        User user = new User();
        user.setName("su");
        List<User> list = null;
        try {
            list = sqlSession.selectList("dynamicIfSql3",user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        for (User user1 : list) {
            System.out.println(user1.toString());
        }
    }
    public void bynamicUpdateSql(){
        sqlSession = build.openSession(true);
        User user = new User();
        user.setName("1");
        user.setId(1);
        int ru = 0;
        try {
            ru = sqlSession.update("bynamicUpdateSql",user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        System.out.println(ru);
    }

    public void dynamicForEachSql(){
        sqlSession = build.openSession(true);
        List<User> userList= null;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        try {
            userList = sqlSession.selectList("dynamicForEachSql",list);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }
}
