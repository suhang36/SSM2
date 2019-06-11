package Dao;

import entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDaoImpl {
     List<User> findUser();
     List<User> findUserParameter(User user);
     List<User> findUserParameterWithName(User user);







































































}
