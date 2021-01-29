package cdu.yd.controller;

import cdu.yd.model.User;
import cdu.yd.service.UserService;
import cdu.yd.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/user/add.do")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        User user = new User();
        user.setName(req.getParameter("name"));
        user.setPassword(req.getParameter("password"));

        PrintWriter out=resp.getWriter();
        UserService userService = new UserServiceImpl();
        if(req.getParameter("name")!=null&&!req.getParameter("name").equals("")&&req.getParameter("password")!=null&&!req.getParameter("password").equals("")){
            if(!userService.insert(user)){
                out.println("<script>alert('添加失败！');window.location.href='user/add_user.jsp'</script>");
            }else{
                out.println("<script>alert('添加成功！');window.location.href='../list'</script>");
            }
        }else {
            out.println("<script>alert('添加失败！用户和密码不能为空');window.location.href='add_user.jsp'</script>");
        }

    }
}
