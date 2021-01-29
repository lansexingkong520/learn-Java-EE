package cdu.five.controller;

import cdu.five.model.Post;
import cdu.five.model.User;
import cdu.five.service.PostService;
import cdu.five.service.UserService;
import cdu.five.service.impl.PostServiceImpl;
import cdu.five.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/userList")
public class UserListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sPage = req.getParameter("page");
        int page = (sPage == null || sPage.equals("")) ? 1 : Integer.parseInt(sPage);
        int pageSize = 10;
        req.setAttribute("page", page);
        req.setAttribute("pageSize", pageSize);

        UserService userService=new UserServiceImpl();
        List<User> userList=userService.findByPage(page,pageSize);

        int userCount=userService.getCount();

        req.setAttribute("userCount",userCount);
        req.setAttribute("pageCount",userCount % pageSize ==0?userCount/pageSize:userCount/pageSize+1);

        req.setAttribute("userList",userList);
        req.getRequestDispatcher("userList.jsp").forward(req,resp);
    }
}
