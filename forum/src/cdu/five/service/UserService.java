package cdu.five.service;

import cdu.five.model.User;

import java.util.List;

public interface UserService {

    boolean register(User user);

    User checkLogin(String username,String password);

    User isRegister(String name);

    boolean insert(User user);

    boolean update(User user);

    boolean delete(int id);

    User findById(int id);

    List<User> findByPage(int page, int pageSize);

    int getCount();

    List<User> findAll();
}
