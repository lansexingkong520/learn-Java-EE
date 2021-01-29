package cdu.yd.biz.util;

import sun.net.ConnectionResetException;

import java.sql.*;

public class JDBC {

    public static Connection connect() throws Exception{
        String driver="com.mysql.cj.jdbc.Driver";
        String url= "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
        String db_user= "root";
        String db_pwd= "520916";
        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url, db_user, db_pwd);
            return conn;
        } catch (Exception e) {
            System.out.println("数据库连接失败："+e.getMessage());
            return null;
        }
    }

    public static void close(Connection conn, PreparedStatement prtmt){
        try {
            if (prtmt != null)
                prtmt.close();
        } catch (SQLException e) {
            System.out.println("数据库关闭连接失败："+e.getMessage());
        }
        try {
            if(conn!=null&&!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("数据库关闭连接失败："+e.getMessage());
        }

    }

    public static void close(Connection conn, PreparedStatement prtmt, ResultSet rs){
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            System.out.println("数据库关闭连接失败："+e.getMessage());
        }
        try {
            if (prtmt != null)
                prtmt.close();
        } catch (SQLException e) {
            System.out.println("数据库关闭连接失败："+e.getMessage());
        }
        try {
            if(conn!=null&&!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("数据库关闭连接失败："+e.getMessage());
        }
    }

}
