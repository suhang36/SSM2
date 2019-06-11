package Service;

import Dao.UserDaoImpl;
import entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {
    public List<User> findUser();
    public List<User> findUserParameter(User user);
    public List<User> findUserParameterWithName(User user);
}
