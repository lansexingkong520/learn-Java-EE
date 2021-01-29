package cdu.yd.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginPage")
public class LoginPageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username="";
        String password="";
        //从客户端读取Cookie
        Cookie[] cookies=req.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                }
                if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
                req.setAttribute("username",username);
                req.setAttribute("password",password);
            }
        }
        req.getRequestDispatcher("view/login.jsp").forward(req,resp);
//        resp.setContentType("text/html;charset=utf8");
//        PrintWriter out = resp.getWriter();
//        out.println("<html><head><title>用户登录</title></head><body>");
//        out.println("<form action='login' method='post'>");
//        out.println("用户名：<input type='text' name='username' value='"+username+"'><br>");
//        out.println("密码：<input type='password' name='password' value='"+password+"'><br>");
//        out.println("验证码：<input type='text' name='inputCode'><img src='validCode' width='80' height='30'><br>");
//        out.println("保存密码：<input type='checkbox' name='saveUN'><br>");
//        out.println("<input type='submit' value='登录'>   ");
//        out.println("<input type='reset' value='重置'><br>");
//        out.println("<a href='register.html'>注册</a><br>");
//        out.println("</form></body></html>");
    }
}
