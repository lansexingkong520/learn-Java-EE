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

@WebServlet("/admin/ess")
public class isEssenceServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();

        int i=Integer.parseInt(req.getParameter("pid"));
        int e=Integer.parseInt(req.getParameter("essence"));

        PostService postService=new PostServiceImpl();
        Post p=postService.queryByPid(i);
        Post post=new Post();

        if(p.getEssence()==1){
            out.println("<script>alert('该贴已为精华！');window.location.href='postList'</script>");
        }else{
            post.setPid(i);
            post.setEssence(e);
            if(postService.updateess(post)){
                out.println("<script>alert('已设为精华！');window.location.href='postList'</script>");
            }else{
                out.println("<script>alert('设置失败！');window.location.href='mod?"+post.getPid()+"'</script>");
            }

        }



    }
}
