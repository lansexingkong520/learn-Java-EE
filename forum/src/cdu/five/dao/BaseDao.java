package cdu.five.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    String driver ="com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/db_forum?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
    String db_user = "root";
    String db_pwd = "520916";

    protected Connection conn=null;

    public BaseDao(){
        connect();
    }

    public void connect() {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, db_user, db_pwd);
        } catch (Exception e) {
            System.out.println("数据库连接失败："+e.getMessage());
        }
    }

    public void close(){
        try {
            if(conn!=null&&!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("数据库关闭连接失败："+e.getMessage());
        }
    }
}
