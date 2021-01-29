package cdu.five.dao.impl;

import cdu.five.dao.BaseDao;
import cdu.five.dao.PostDao;
import cdu.five.model.Post;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl extends BaseDao implements PostDao {

    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public int insert(Post post) {
        int rows = 0;
        String sql = "insert into tb_post(time,title,content,uid,essence,top) values(?,?,?,?,0,0)";
        System.out.println(post.getTime());
        System.out.println(post.getTitle());
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1,post.getTime());
            pstmt.setString(2,post.getTitle());
            pstmt.setString(3,post.getContent());
            pstmt.setInt(4,post.getUid());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("添加帖子失败："+post);
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<Post> findByPage(int start, int num) {
        List<Post>  postList = new ArrayList<Post>();
        String sql = "SELECT * FROM tb_post p,tb_user u WHERE p.uid=u.uid  ORDER BY top DESC,time DESC LIMIT ?,?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, num);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Post post= new Post();
                post.setPid(rs.getInt("pid"));
                post.setUid(rs.getInt("uid"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setTime(rs.getTimestamp("time"));
                post.setEssence(rs.getInt("essence"));
                post.setTop(rs.getInt("top"));
                post.setUname(rs.getString("name"));
                postList.add(post);
            }
        } catch (SQLException e) {
            System.out.println("分页查询失败start=" + start + ",num=" + num);
            e.printStackTrace();
        }
        return   postList;
    }

    @Override
    public List<Post> findByPageAndId(int start, int num) {
        List<Post>  postList = new ArrayList<Post>();
        String sql = "SELECT * FROM tb_post p,tb_user u WHERE p.uid=u.uid ORDER BY pid  LIMIT ?,?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, num);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Post post= new Post();
                post.setPid(rs.getInt("pid"));
                post.setUid(rs.getInt("uid"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setTime(rs.getTimestamp("time"));
                post.setEssence(rs.getInt("essence"));
                post.setTop(rs.getInt("top"));
                post.setUname(rs.getString("name"));
                postList.add(post);
            }
        } catch (SQLException e) {
            System.out.println("分页查询失败start=" + start + ",num=" + num);
            e.printStackTrace();
        }
        return   postList;
    }

    @Override
    public int getCount() {
        int count = 0;
        //todo
        String sql = "SELECT count(*) FROM tb_post";
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

    @Override
    public Post queryByPid(int pid) {
        Post post = null;
        String sql = "SELECT * FROM tb_post p, tb_user u WHERE p.uid=u.uid AND p.pid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pid);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                post= new Post();
                post.setPid(rs.getInt("pid"));
                post.setUid(rs.getInt("uid"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setTime(rs.getTimestamp("time"));
                post.setEssence(rs.getInt("essence"));
                post.setTop(rs.getInt("top"));
                post.setUname(rs.getString("name"));
                post.setUpic(rs.getString("pic"));
            }
        } catch (SQLException e) {
            System.out.println("帖子id查询失败pid=" + pid);
            e.printStackTrace();
        }
        return   post;
    }

    @Override
    public int updatetop(Post post) {
        int rows=0;
        String sql="update  tb_post set top=? where pid=? ";
        try{

            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,post.getTop());
            pstmt.setInt(2,post.getPid());

            rows=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("数据库修改帖子失败："+post+","+sql);
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int updateess(Post post) {
        int rows=0;
        String sql="update  tb_post set essence=? where pid=? ";
        try{

            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,post.getEssence());
            pstmt.setInt(2,post.getPid());

            rows=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("数据库修改帖子失败："+post+","+sql);
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<Post> findAll() {
        return findByPage(0,Integer.MAX_VALUE);
    }

    @Override
    public int delete(int id) {
        int rows=0;
        String sql="delete p,c from tb_post p LEFT JOIN tb_conment c ON p.pid = c.pid where p.pid=? ";
        try{

            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rows=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("数据库删除帖子失败："+e.getMessage());
            e.printStackTrace();
        }
        return rows;
    }
}
