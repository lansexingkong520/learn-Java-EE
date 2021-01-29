package cdu.five.controller;

import cdu.five.service.PostService;
import cdu.five.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/postdel.do")
public class DeletePostServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pId=req.getParameter("pid");
        System.out.println(pId);
        int id=(pId==null|| pId.equals(""))?0:Integer.parseInt(pId);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out=resp.getWriter();

        PostService postService=new PostServiceImpl();
        if(!postService.delete(id)){
            out.println("<script>alert('删除成功id="+id+"');window.location.href='postList'</script>");
        }else{
            out.println("<script>alert('删除失败id="+id+"');window.location.href='postList'</script>");
        }
    }
}
