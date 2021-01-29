package cdu.yd.dao.impl;

import cdu.yd.dao.BaseDao;
import cdu.yd.dao.UserDao;
import cdu.yd.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public int insert(User user) {
        int rows = 0;
        String sql = "insert into table_user(name,password) values(?,?)";

        System.out.println(user.getName());
        System.out.println(user.getPassword());
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("添加用户失败："+user);
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int update(User user) {
        int rows=0;
        String sql = "update table_user set name=?,password=? where id=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setInt(3,user.getId());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("修改用户失败："+user);
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows=0;
        String sql = "delete from table_user where id=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("删除用户失败："+id);
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public User findByNameAndPwd(String name, String password) {
        User user=null;
        String sql = "SELECT *FROM table_user WHERE name=? and password=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("用户查询失败name="+name+",pwd="+password);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return findByPage(0,-1);
    }

    @Override
    public List<User> findByPage(int start, int num) {
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT *FROM table_user ORDER BY id DESC LIMIT ?,?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,start);
            pstmt.setInt(2,num);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println("分页查询失败start="+start+",num="+num);
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(int id) {
        User user = null;
        String sql = "SELECT *FROM table_user WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("用户查询失败id="+id);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int getCount() {
        int count = 0;
        String sql="SELECT count(*) FROM table_user";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("查询人数失败sql="+sql);
            e.printStackTrace();
        }
        return count;
    }
}
