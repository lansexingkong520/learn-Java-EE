package cdu.five.controller;

import cdu.five.model.Conment;
import cdu.five.model.Post;
import cdu.five.service.ConmentService;
import cdu.five.service.PostService;
import cdu.five.service.impl.ConmentServiceImpl;
import cdu.five.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/commentList")
public class CommentListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pid = req.getParameter("pid");
        int id = (pid == null || pid.equals(""))?0 : Integer.parseInt(pid);

        System.out.println(pid);
        PostService postService = new PostServiceImpl();
        Post post = postService.queryByPid(id);
        req.setAttribute("post",post);


        String sPage = req.getParameter("page");
        int page = (sPage == null || sPage.equals("")) ? 1 : Integer.parseInt(sPage);
        int pageSize = 10;
        req.setAttribute("page", page);
        req.setAttribute("pageSize", pageSize);

        ConmentService conmentService = new ConmentServiceImpl();
        List<Conment> conmentList = conmentService.findByPage(page,pageSize,id);

        req.setAttribute("conment",conmentList);
        System.out.println(conmentList);
        int conmentCount=conmentService.getCount(id);
        req.setAttribute("conmentCount",conmentCount);
        req.setAttribute("pageCount",conmentCount % pageSize ==0?conmentCount/pageSize:conmentCount/pageSize+1);
        req.getRequestDispatcher("content.jsp").forward(req,resp);
    }
}
