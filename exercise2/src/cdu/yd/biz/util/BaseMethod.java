package cdu.yd.biz.util;

import cdu.yd.bean.Candidate;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.TimeZone;

public class BaseMethod extends JDBC {
    private static PreparedStatement pstmt= null ;
    private static ResultSet rs=null;
    private static Connection conn;

    static {
        try {
            conn = JDBC.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //添加
    public  static int insert(Candidate candidate){
        int rows = 0;
        String sql = "insert into table_candidate(name,photoUrl) values(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,candidate.getName());
            pstmt.setString(2,candidate.getPhotoUrl());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("添加用户失败："+candidate);
            e.printStackTrace();
        }
        return rows;
    }
    //投票
    public static int updateVote(int id){
        int rows = 0;
        String sql = "UPDATE  table_candidate SET votes = votes + 1 WHERE id = ?";
        PreparedStatement pstmt = null;
        System.out.println(conn);
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    //修改
    public static int update(Candidate candidate){
        int rows = 0;
        String sql = "UPDATE  table_candidate SET name = ?, photoUrl = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,candidate.getName());
            pstmt.setString(2,candidate.getPhotoUrl());
            pstmt.setInt(3,candidate.getId());
            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("数据库修改用户失败："+candidate+","+sql);
            e.printStackTrace();
        }
        return rows;
    }
    //删除
    public static int delete(int id){
        int rows = 0;
        String sql = "delete from table_candidate where id=?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    //查询单个
    public static Candidate queryById(int id){
        Candidate candidate = null;
        String sql = "SELECT *FROM table_candidate WHERE id=?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            while (rs.next()){
                candidate = new Candidate();
                candidate.setId(rs.getInt("id"));
                candidate.setName(rs.getString("name"));
                candidate.setPhotoUrl(rs.getString("photoUrl"));
                candidate.setVotes(rs.getInt("votes"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidate;
    }
    //查询列表所有+分页 用户看投票数降序
    public static List<Candidate> query(int start, int num){
        List<Candidate> candidates = new ArrayList<Candidate>();
        String sql = "SELECT *FROM table_candidate ORDER  BY votes DESC LIMIT ?,? ";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, num);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Candidate candidate = new Candidate();
                candidate.setId(rs.getInt("id"));
                candidate.setName(rs.getString("name"));
                candidate.setPhotoUrl(rs.getString("photoUrl"));
                candidate.setVotes(rs.getInt("votes"));
                candidates.add(candidate);
            }
        } catch (SQLException e) {
            System.out.println("分页查询失败start=" + start + ",num=" + num);
            e.printStackTrace();
        }
        return candidates;
    }

    //查询列表所有+分页 管理按id升序
    public static List<Candidate> queryAll(int start, int num){
        List<Candidate> candidates = new ArrayList<Candidate>();
        String sql = "SELECT *FROM table_candidate LIMIT ?,? ";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, num);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Candidate candidate = new Candidate();
                candidate.setId(rs.getInt("id"));
                candidate.setName(rs.getString("name"));
                candidate.setPhotoUrl(rs.getString("photoUrl"));
                candidate.setVotes(rs.getInt("votes"));
                candidates.add(candidate);
            }
        } catch (SQLException e) {
            System.out.println("分页查询失败start=" + start + ",num=" + num);
            e.printStackTrace();
        }
        return candidates;
    }

    public static int getCount() {
        int count=0;
        String sql = "SELECT count(*) FROM table_candidate";
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

    //查询访问ip是否存在
    public static boolean checkIp(String ip){
        String sIp = null;
        String sql = "SELECT *FROM table_ip WHERE ip=?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ip);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                sIp=rs.getString("ip");
            }
        } catch (SQLException e) {
            System.out.println("查询失败");
            e.printStackTrace();
        }
        return sIp!=null;
    }
    //查询存在ip的时间
    public static boolean checkStatus(String ip){
        Date time = null;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-hh");
        long time1 = date.getTime();
        String timeStr1 = sdf.format(time1);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-6"));
        String sql = "SELECT *FROM table_ip WHERE ip=?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ip);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                time = rs.getDate("time");
            }
        } catch (SQLException e) {
            System.out.println("查询失败");
            e.printStackTrace();
        }
        String timeStr = sdf.format(time);

//        System.out.println(time);
//        System.out.println(time1);
//        System.out.println(timeStr);
//        System.out.println(timeStr1);
//        try {
//            System.out.println(sdf.parse(timeStr1));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        if (timeStr.equals(timeStr1)){
//            System.out.println(1);
//        }else {
//            System.out.println(0);
//        }
//        System.out.println(timeStr);
//        System.out.println(timeStr1);
//        if(timeStr.equals(timeStr1)){
//            System.out.println("等于");
//        }else {
//            System.out.println("不等于");
//        }
        if(!timeStr.equals(timeStr1)){
            return true;
        }else {
            return false;
        }

    }
    //添加ip
    public  static int insertIp(String ip){
        int rows = 0;
        Timestamp time =new Timestamp(new java.util.Date().getTime());
        String sql = "insert into table_ip(ip,status,time) values(?,1,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,ip);
            pstmt.setTimestamp(2,time);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("添加ip失败："+ip);
            e.printStackTrace();
        }
        return rows;
    }
    //修改
    public static int updateStatus(String ip){
        int rows = 0;
        Date date = new Date();
        Timestamp time =new Timestamp(new java.util.Date().getTime());
        //java.sql.Date time = new java.sql.Date(date.getTime());
        String sql = "UPDATE  table_ip SET status = 1, time = ? WHERE ip = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1,time);
            pstmt.setString(2,ip);
            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("数据库修改失败");
            e.printStackTrace();
        }
        return rows;
    }
}
