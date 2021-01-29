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

@WebServlet("/admin/top")
public class isTopServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();

        int i=Integer.parseInt(req.getParameter("pid"));
        int t=Integer.parseInt(req.getParameter("top"));

        PostService postService=new PostServiceImpl();
        Post p=postService.queryByPid(i);
        Post post=new Post();

        if(p.getTop()==1){
            out.println("<script>alert('该贴已被置顶！');window.location.href='postList'</script>");
        }else{
            post.setPid(i);
            post.setTop(t);

            if(postService.updatetop(post)){
                out.println("<script>alert('已被置顶！');window.location.href='postList'</script>");
            }else{
                out.println("<script>alert('设置失败！');window.location.href='mod?"+post.getPid()+"'</script>");
            }

        }
    }
}
