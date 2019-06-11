package Service.impl;

import Service.UserService;
import entity.User;

import java.util.List;

public class test implements UserService {
    @Override
    public List<User> findUser() {
        return null;
    }

    @Override
    public List<User> findUserParameter(User user) {
        return null;
    }

    @Override
    public List<User> findUserParameterWithName(User user) {
        return null;
    }
}
