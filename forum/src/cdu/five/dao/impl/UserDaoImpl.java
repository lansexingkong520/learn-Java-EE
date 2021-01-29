package cdu.five.dao.impl;

import cdu.five.dao.BaseDao;
import cdu.five.dao.UserDao;
import cdu.five.model.User;

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
        String sql = "insert into tb_user(name,pwd,sex,pic,status) values(?,?,?,?,0)";
        System.out.println(user.getName());
        System.out.println(user.getPwd());
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPwd());
            pstmt.setString(3,user.getSex());
            pstmt.setString(4,user.getPic());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("添加用户失败："+user);
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(int id) {
        int rows=0;
        String sql="delete u,p,c from tb_user u LEFT JOIN tb_post p ON u.uid=p.uid LEFT JOIN tb_conment c ON p.pid = c.pid where u.uid=?";
        try{

            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rows=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("数据库删除用户失败："+e.getMessage());
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public User findByNameAndPwd(String name, String password) {
        User user=null;
        String sql = "SELECT *FROM tb_user WHERE name=? and pwd=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            while (rs.next()){
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setPic(rs.getString("pic"));
                user.setStatus(rs.getInt("status"));
            }
        } catch (SQLException e) {
            System.out.println("用户查询失败name="+name+",pwd="+password);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByName(String name) {
        User user=null;
        String sql = "SELECT *FROM tb_user WHERE name=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            rs = pstmt.executeQuery();
            while (rs.next()){
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setPic(rs.getString("pic"));
                user.setStatus(rs.getInt("status"));
            }
        } catch (SQLException e) {
            System.out.println("用户查询失败name="+name);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return findByPage(0,Integer.MAX_VALUE);
    }

    @Override
    public List<User> findByPage(int start, int num) {
        List<User> userList=new ArrayList<>();
        String sql="select *from tb_user order by uid limit ?,?";
        try{

            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,start);
            pstmt.setInt(2,num);
            rs = pstmt.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setUid((rs.getInt("uid")));
                user.setName((rs.getString("name")));
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println("数据库查询用户失败："+sql);
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(int id) {
        User user=null;
        String sql="select  * from tb_user  where uid=? ";
        try{

            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            while(rs.next()){
                user=new User();
                user.setUid((rs.getInt("uid")));
                user.setName((rs.getString("name")));

            }
        } catch (SQLException e) {
            System.out.println("数据库查询用户失败："+sql);
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public int getCount() {
        int count = 0;
        //todo
        String sql = "SELECT count(*) FROM tb_user";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("sql查询失败sql=" + sql);
            e.printStackTrace();
        }
        return count;
    }
}
