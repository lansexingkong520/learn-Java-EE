package cdu.five.controller;

import cdu.five.model.Conment;
import cdu.five.model.Post;
import cdu.five.model.User;
import cdu.five.service.ConmentService;
import cdu.five.service.impl.ConmentServiceImpl;
import cdu.five.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

@WebServlet("/user/addComment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String spid = req.getParameter("pid");
        System.out.println(user);
        System.out.println(spid);
        int uid = user.getUid();
        int pid = (spid == null || spid.equals("")) ? 1 : Integer.parseInt(spid);
        String content = req.getParameter("content");

        Conment conment = new Conment();
        conment.setPid(pid);
        conment.setUid(uid);
        conment.setContent(content);
        conment.setCtime(new Timestamp(new java.util.Date().getTime()));

        PrintWriter out=resp.getWriter();
        ConmentServiceImpl conmentService = new ConmentServiceImpl();
        PostServiceImpl postService = new PostServiceImpl();
        Post post = postService.queryByPid(pid);
        req.setAttribute("post",post);

        if(content!=null&&!content.equals("")){
            if(!conmentService.insert(conment)){
                req.getRequestDispatcher("commentList").forward(req,resp);

            }else{
                req.getRequestDispatcher("commentList").forward(req,resp);
            }
        }else {
            req.getRequestDispatcher("commentList").forward(req,resp);
        }
    }
}
