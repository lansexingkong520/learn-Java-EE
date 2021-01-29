package cdu.yd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //强制会话失效
        HttpSession session = req.getSession();
        session.invalidate();

        //跳出弹窗
        //跳转登录页面
        resp.setContentType("text/html;charset=utf8");
        PrintWriter out = resp.getWriter();
        out.write("<script language='javascript'>");
        out.write("alert('此用户已注销。');");
        out.write("location.href='loginPage'");
        out.write("</script>");
        out.flush();
//        resp.sendRedirect("loginPage");
    }
}





