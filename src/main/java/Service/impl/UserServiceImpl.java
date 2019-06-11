package Service.impl;

import Dao.UserDaoImpl;
import Service.UserService;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl userDao;
    @Override
    public List<User>findUser() {
        return userDao.findUser();
    }

    @Override
    public List<User> findUserParameter(User user) {
        System.out.println(user);
        return userDao.findUserParameter(user);
    }

    @Override
    public List<User> findUserParameterWithName(User user) {
       return userDao.findUserParameterWithName(user);
    }
}
