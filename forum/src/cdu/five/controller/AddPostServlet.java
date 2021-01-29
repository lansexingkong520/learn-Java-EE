package cdu.five.controller;

import cdu.five.model.Post;
import cdu.five.model.User;
import cdu.five.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;

@WebServlet("/user/addPost")
public class AddPostServlet extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        System.out.println(user);

        int uid = user.getUid();
        System.out.println(uid);
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        Post post = new Post();
        post.setTime(new Timestamp(new java.util.Date().getTime()));
        post.setTitle(title);
        post.setContent(content);
        post.setUid(uid);

        PrintWriter out=resp.getWriter();
        PostServiceImpl postService = new PostServiceImpl();

        if(req.getParameter("title")!=null&&!req.getParameter("title").equals("")&&req.getParameter("content")!=null&&!req.getParameter("content").equals("")){
            if(!postService.insert(post)){
                out.println("<script>alert('发帖失败！');window.location.href='write.jsp'</script>");
            }else{
                out.println("<script>alert('发帖成功！');window.location.href='list'</script>");
            }
        }else {
            out.println("<script>alert('发帖失败！主题或内容不能为空');window.location.href='write.jsp'</script>");
        }


    }
}
