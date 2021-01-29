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

@WebServlet("/user/mod.do")
public class ModUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter out=resp.getWriter();

        User user = new User();
        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setName(req.getParameter("name"));
        user.setPassword(req.getParameter("password"));

        UserService userService = new UserServiceImpl();
        if(userService.update(user)){
            out.println("<script>alert('修改成功！');window.location.href='../list'</script>");
        }else{
            out.println("<script>alert('修改失败！');window.location.href='mod?"+user.getId()+"'</script>");
        }

    }
}
