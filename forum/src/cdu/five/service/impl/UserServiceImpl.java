package cdu.five.service.impl;

import cdu.five.dao.UserDao;
import cdu.five.dao.impl.UserDaoImpl;
import cdu.five.model.User;
import cdu.five.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public User checkLogin(String username, String password) {

        return userDao.findByNameAndPwd(username,password);
    }

    @Override
    public User isRegister(String name) {
        return userDao.findByName(name);
    }

    @Override
    public boolean insert(User user) {
        return userDao.insert(user) == 1 ? true : false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return userDao.delete(id)==1 ? true : false;
    }

    @Override
    public User findById(int id) {

        return userDao.findById(id);
    }


    @Override
    public List<User> findByPage(int page, int pageSize) {
        return userDao.findByPage(page,pageSize);
    }

    @Override
    public int getCount() {
        return userDao.getCount();
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
