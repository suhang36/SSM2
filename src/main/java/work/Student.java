package work;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Student {
    public void extude() throws IOException {
        //获取全局配置的连接inputStream流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //建立和启动连接
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得连接后的sql对象
        SqlSession sqlSession = build.openSession();
        //执行sql语句
        List<Object> findStudent = sqlSession.selectList("findStudent");
        System.out.println(findStudent);
    }
}
