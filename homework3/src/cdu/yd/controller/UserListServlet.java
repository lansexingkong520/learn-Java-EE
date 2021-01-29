package cdu.yd.controller;

import cdu.yd.model.User;
import cdu.yd.service.UserService;
import cdu.yd.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class UserListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //分页
        String sPage = req.getParameter("page");
        int page = (sPage==null||sPage.equals(""))? 1: Integer.parseInt(sPage);
        int pageSize = 2;
        req.setAttribute("page",page);
        req.setAttribute("pageSize",pageSize);

        //输出用户信息
        UserService userService=new UserServiceImpl();
        List<User> userList = userService.findByPage(page,pageSize);

        req.setAttribute("user",userList);
        int userCount = userService.getCount();
        req.setAttribute("userCount",userCount);
        req.setAttribute("pageCount",userCount%pageSize == 0? userCount/pageSize : userCount / pageSize+1);

        req.getRequestDispatcher("view/userList.jsp").forward(req,resp);
    }
}
