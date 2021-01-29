package cdu.yd.dao;

import cdu.yd.model.User;

import java.util.List;

public interface UserDao {

    int insert(User user);

    int update(User user);

    int delete(int id);

    User findByNameAndPwd(String name,String password);

    List<User> findAll();

    List<User> findByPage(int start,int num);

    User findById(int id);

    int getCount();
}
