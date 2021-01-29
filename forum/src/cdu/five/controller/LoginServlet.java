package cdu.five.controller;

import cdu.five.model.User;
import cdu.five.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //请求参数不为乱码
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String inputCode = req.getParameter("inputCode");
        String savedUser = req.getParameter("savedUser");
        String sStatus = req.getParameter("status");
        int status = (sStatus == null || sStatus.equals("")) ? 0 : Integer.parseInt(sStatus);

//        Cookie cName=new Cookie("name",name);
//        Cookie cPwd=new Cookie("pwd",pwd);
//        if(savedUser!=null&&savedUser.equals("on")){
//            cName.setMaxAge(60*60*24*7);
//            cPwd.setMaxAge(60*60*24*7);
//            resp.addCookie(cName);
//            resp.addCookie(cPwd);
//        }else {
//            String header=req.getHeader("localhost");
//            System.out.println(header);
//            cName.setDomain("."+header);
//            cName.setPath(req.getContextPath());
//            cName.setMaxAge(0);
//
//            cPwd.setPath(req.getContextPath());
//            cPwd.setMaxAge(0);
//            resp.addCookie(cName);
//            resp.addCookie(cPwd);
//        }


        //验证验证码
        HttpSession session = req.getSession();
        //在会话中保存登录用户信息
        session.setAttribute("name", name);
        session.setAttribute("pwd", pwd);

        PrintWriter out = resp.getWriter();
        String validCode = (String) session.getAttribute("validCode");

        if (validCode == null || validCode.equals("") || !validCode.equals(inputCode)) {
            out.println("<script>alert('验证码有误！');window.location.href='/'</script>");
            return;
        }

        UserServiceImpl service = new UserServiceImpl();
        User user = service.checkLogin(name, pwd);
        System.out.println(name + pwd);
        System.out.println(user);
        session.setAttribute("uid", user.getUid());

        if (user == null) {
            out.println("<script>alert('登录失败！');window.location.href='/'</script>");
        } else if (status == 1 && status == user.getStatus()) {
            session.setAttribute("user", user);
            //TODO  管理员跳管理页面，帖子列表
            out.println("<script>alert('管理员登录成功！');window.location.href='http://localhost:8080/admin/aindex.jsp'</script>");
        } else if (status == 0 && status == user.getStatus()) {
            session.setAttribute("user", user);
            //TODO  用户跳浏览页面
            out.println("<script>alert('用户登录成功！');window.location.href='http://localhost:8080/user/uindex.jsp'</script>");
        } else {
            out.println("<script>alert('登录失败！');window.location.href='/'</script>");
        }
    }
}
