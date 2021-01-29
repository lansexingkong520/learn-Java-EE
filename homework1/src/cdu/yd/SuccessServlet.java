package cdu.yd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        resp.setContentType("text/html;charset=utf8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>登录成功</title></head><body>");
        out.println("<h1>欢迎你，"+username+"，"+password+"</h1>");
        out.println("<a href='logout'>注销</a><br>");
        out.println("</body></html>");
        out.close();

    }
}
