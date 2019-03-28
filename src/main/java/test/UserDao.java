package test;

import MyImpl.UserDaoImpl;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class UserDao {
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
    public void setUserDao(){
        List<User> users = null;
        SqlSession session = build.openSession();

        try {
            UserDaoImpl userDao = sqlSession.getMapper(UserDaoImpl.class);
           users  = userDao.findUser();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        for (User user : users) {
            System.out.println(user.toString());
        }

    }


}
class test1{
    public static void main(String[] args) {
        UserDao dao = new UserDao();
        dao.setUserDao();
    }
}