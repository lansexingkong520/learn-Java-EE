package cdu.yd.biz.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/addPre")
public class AddCandidatePageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>添加候选人</title></head><body>");
        out.println("<h1>添加候选人</h1><br>");
        out.println("<form action='add' method='post' enctype='multipart/form-data'>");
        out.println("候选人姓名：<input type='text' name='username'><br>");
        out.println("候选人照片：<input type='file' name='photo'><br>");
        out.println("<input type='submit' value='添加'>   ");
        out.println("<input type='reset' value='重置'><br>");
        out.println("<span><a href='http://localhost:8080/admin/manage'>管理候选人</a></span><br>");
        out.println("</form></body></html>");
    }
}
