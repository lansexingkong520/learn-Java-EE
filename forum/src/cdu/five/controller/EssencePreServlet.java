package cdu.five.controller;

import cdu.five.model.Post;
import cdu.five.service.PostService;
import cdu.five.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/emod")
public class EssencePreServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pId=req.getParameter("pid");

        int pid=(pId==null||pId.equals(""))?0:Integer.valueOf(pId);

        PrintWriter out=resp.getWriter();
        PostService postService=new PostServiceImpl();
        Post post=postService.queryByPid(pid);

        if(post==null){
            out.println("<script>alert('修改失败！id="+pid+"');window.location.href='list'</script>");
        }else{
            req.setAttribute("post",post);
            req.getRequestDispatcher("essence.jsp").forward(req,resp);
        }
        out.close();
    }
}
