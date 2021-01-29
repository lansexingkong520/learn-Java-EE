package cdu.yd.controller;

import cdu.yd.service.UserService;
import cdu.yd.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/del")
public class DelUserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sId = req.getParameter("id");

        int id = (sId == null || sId.equals(""))?0 : Integer.parseInt(sId);

        PrintWriter out=resp.getWriter();
        UserService userService=new UserServiceImpl();
        if(userService.delete(id)){
            out.println("<script>alert('删除成功id="+id+"');window.location.href='list'</script>");
        }else{
            out.println("<script>alert('删除失败id="+id+"');window.location.href='list'</script>");
        }
    }
}
