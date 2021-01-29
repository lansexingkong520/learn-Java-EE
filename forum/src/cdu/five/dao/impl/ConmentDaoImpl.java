package cdu.five.dao.impl;

import cdu.five.dao.BaseDao;
import cdu.five.dao.ConmentDao;
import cdu.five.model.Conment;
import cdu.five.model.Post;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConmentDaoImpl extends BaseDao implements ConmentDao {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public int insert(Conment conment) {
        int rows = 0;
        String sql = "insert into tb_conment (pid,uid,content,ctime) values(?,?,?,?)";
        System.out.println(conment.getCtime());
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,conment.getPid());
            pstmt.setInt(2,conment.getUid());
            pstmt.setString(3,conment.getContent());
            pstmt.setTimestamp(4,conment.getCtime());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("添加评论失败："+conment);
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<Conment> findByPage(int start, int num,int id) {
        List<Conment> conmentList  = new ArrayList<Conment>();
        String sql = "SELECT * FROM tb_conment c, tb_post p,tb_user u WHERE c.uid=u.uid AND c.pid=? AND p.pid=? ORDER BY ctime DESC LIMIT ?,?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setInt(2, id);
            pstmt.setInt(3, start);
            pstmt.setInt(4, num);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Conment conment = new Conment();
                conment.setCid(rs.getInt("cid"));
                conment.setPid(rs.getInt("pid"));
                conment.setUid(rs.getInt("uid"));
                conment.setContent(rs.getString("content"));
                conment.setCtime(rs.getTimestamp("ctime"));
                conment.setUname(rs.getString("name"));
                conmentList.add(conment);
            }
        } catch (SQLException e) {
            System.out.println("分页查询失败start=" + start + ",num=" + num);
            e.printStackTrace();
        }
        return   conmentList;
    }

    @Override
    public int  getCount(int id) {
        int count = 0;
        String sql = "SELECT count(*) FROM tb_conment WHERE pid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
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
