package cdu.yd.controller;

import cdu.yd.model.User;
import cdu.yd.service.UserService;
import cdu.yd.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        String rUsername = req.getParameter("rUsername");
        String rPassword = req.getParameter("rPassword");
        UserService userService=new UserServiceImpl();
        User user=userService.isRegister(rUsername);
        User user1=new User();
        if(rUsername==null||rPassword==null||rUsername.equals("")||rPassword.equals("")){
            out.println("<script>alert('注册失败!信息不能为空！');window.location.href='register.jsp'</script>");
        }else if(user!=null){
            out.println("<script>alert('注册失败！用户名有一样的了');window.location.href='register.jsp'</script>");
        } else {
            user1.setName(rUsername);
            user1.setPassword(rPassword);
            if(!userService.insert(user1)){
                out.println("<script>alert('注册失败！');window.location.href='register.jsp'</script>");
            }else{
                HttpSession session = req.getSession();
                session.setAttribute("user",user1);
                out.println("<script>alert('注册成功！');window.location.href='/'</script>");
            }
        }
    }
}
