package cdu.yd.service.impl;

import cdu.yd.dao.UserDao;
import cdu.yd.dao.impl.UserDaoImpl;
import cdu.yd.model.User;
import cdu.yd.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(User user) {
        return userDao.insert(user) == 1 ? true : false;
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
        return userDao.update(user) ==1 ? true : false;
    }

    @Override
    public boolean delete(int id) {

        return userDao.delete(id) == 1 ?true : false;
    }

    @Override
    public User get(int id) {

        return userDao.findById(id);
    }

    @Override
    public List<User> findByPage(int page, int pageSize) {
        if(page>0){
            return userDao.findByPage((page-1)*pageSize,pageSize);
        }else {
            return userDao.findByPage(0,pageSize);
        }
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
