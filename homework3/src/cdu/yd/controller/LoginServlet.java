package cdu.yd.controller;

import cdu.yd.model.User;
import cdu.yd.service.UserService;
import cdu.yd.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view/login.do")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        PrintWriter out=resp.getWriter();
        //验证验证码
        HttpSession session = req.getSession();
        String validCode = (String) session.getAttribute("validCode");

        if(validCode==null||validCode.equals("")||!validCode.equals(inputCode)){
            out.println("<script>alert('验证码有误！');window.location.href='/'</script>");
            return;
        }

        //验证用户是否存在
        UserService userService=new UserServiceImpl();
        User user=userService.checkLogin(username,password);
        if(user==null){
             out.println("<script>alert('登录失败！');window.location.href='/'</script>");
        }else{
            session.setAttribute("user",user);
            out.println("<script>alert('登录成功！');window.location.href='../list'</script>");
        }
    }
}
