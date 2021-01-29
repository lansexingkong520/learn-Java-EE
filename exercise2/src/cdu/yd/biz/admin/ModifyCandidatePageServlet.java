package cdu.yd.biz.admin;

import cdu.yd.bean.Candidate;
import cdu.yd.biz.util.BaseMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/admin/modPre")
public class ModifyCandidatePageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //修改候选人，先拿到候选人的id
        String sId = req.getParameter("id");
        int id = (sId == null || sId.equals(""))?0 : Integer.parseInt(sId);

        //查找数据库修改候选人信息
        Candidate candidate= BaseMethod.queryById(id);

        resp.setContentType("text/html;charset=utf8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>修改候选人信息</title></head><body>");
        out.println("<h1>修改候选人信息</h1><br>");
        out.println("<form action='mod' method='post' enctype='multipart/form-data'>");
        out.println("id:<input type = 'text' name = 'id'  readonly value =" + candidate.getId() + "><br>");
        out.println("候选人姓名：<input type='text' name='username' value ="+candidate.getName()+"><br>");
        out.println("候选人照片：<input type='file' name='img'><br><img src='http://localhost:8080/display?photoUrl=" + candidate.getPhotoUrl() + "' width='100px'><br>");
        out.println("票数：<input type='text' name = 'votes' disabled ='true'  value = " + candidate.getVotes() + "><br>");
        out.println("<input type='submit' value='提交'>   ");
        out.println("<span><a href='http://localhost:8080/admin/manage'>管理候选人</a></span><br>");
        out.println("</form></body></html>");
    }
}
