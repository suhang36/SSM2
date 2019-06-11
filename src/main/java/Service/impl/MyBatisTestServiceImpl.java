package Service.impl;

import Dao.SchoolDao;
import Service.MyBatisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBatisTestServiceImpl implements MyBatisTestService {
    @Autowired
    SchoolDao schoolDao;

    @Override
    public void test(){
        System.out.println(schoolDao.queryForSchoolName("重庆工程学院"));
    }
}
