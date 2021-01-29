package cdu.five.controller;

import cdu.five.service.UserService;
import cdu.five.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/userdel.do")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uId=req.getParameter("uid");
        System.out.println(uId);
        int id=(uId==null|| uId.equals(""))?0:Integer.parseInt(uId);

        PrintWriter out=resp.getWriter();

        UserService userService=new UserServiceImpl();
        if(!userService.delete(id)){
            out.println("<script>alert('删除成功id="+id+"');window.location.href='userList'</script>");
        }else{
            out.println("<script>alert('删除失败id="+id+"');window.location.href='userList'</script>");
        }

    }
}
