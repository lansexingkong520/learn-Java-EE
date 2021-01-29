package cdu.yd.service;

import cdu.yd.model.User;

import java.util.List;

public interface UserService {
    boolean register(User user);

    User checkLogin(String username,String password);

    boolean insert(User user);

    boolean update(User user);

    boolean delete(int id);

    User get(int id);

    List<User> findByPage(int page, int pageSize);

    int getCount();

    List<User> findAll();
}
