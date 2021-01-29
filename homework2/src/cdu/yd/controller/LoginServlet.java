package cdu.yd.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String inputCode = req.getParameter("inputCode");
        String saveUN = req.getParameter("saveUN");

        Cookie cName = new Cookie("username",username);
        Cookie cPwd = new Cookie("password",password);
        if(saveUN!=null&&saveUN.equals("on")){
            cName.setMaxAge(60*60*24*7);
            cPwd.setMaxAge(60*60*24*7);
            resp.addCookie(cName);
            resp.addCookie(cPwd);
        }else {
            String str = req.getHeader("host");
            String header = str.substring(0,str.indexOf(":"));
            cName.setDomain(header);
            cName.setPath(req.getContextPath());
            cName.setMaxAge(0);
            cPwd.setDomain(header);
            cPwd.setPath(req.getContextPath());
            cPwd.setMaxAge(0);
            resp.addCookie(cName);
            resp.addCookie(cPwd);
        }
        if(username==null||password==null||inputCode==null||username.equals("")||password.equals("")||inputCode.equals("")){
            resp.sendRedirect("loginPage");
            return;
        }

        //验证验证码
        HttpSession session = req.getSession();
        String validCode = (String) session.getAttribute("validCode");
        if(validCode==null||validCode.equals("")||!validCode.equals(inputCode)){
            resp.sendRedirect("loginPage");
            return;
        }

        //验证用户名和密码
        if(username.equals(password)){
            resp.sendRedirect("success");
            //保存用户的登录信息
            session.setAttribute("username",username);
            session.setAttribute("password",password);
        }else {
            resp.sendRedirect("loginPage");
        }
    }
}
