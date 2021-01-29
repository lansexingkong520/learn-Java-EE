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

@WebServlet("/mod")
public class ModUserBeforeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId = req.getParameter("id");
        System.out.println("要修改的id："+sId);

        int id = (sId == null||sId.equals(""))?0:Integer.parseInt(sId);

        PrintWriter out=resp.getWriter();
        UserService userService=new UserServiceImpl();
        User user=userService.get(id);
        if(user==null){
            out.println("<script>alert('修改失败！id="+id+"');window.location.href='list'</script>");
        }else{
            req.setAttribute("oldUser",user);
            req.getRequestDispatcher("view/mod_user.jsp").forward(req,resp);
        }
        out.close();
    }
}
