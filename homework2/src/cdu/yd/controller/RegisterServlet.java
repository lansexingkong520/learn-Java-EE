package cdu.yd.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf8");
        PrintWriter out = resp.getWriter();
        String rUsername = req.getParameter("rUsername");
        String rPassword = req.getParameter("rPassword");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String[] hobby = req.getParameterValues("hobby");

        if(rUsername==null||rPassword==null||rUsername.equals("")||rPassword.equals("")){
            out.write("<script language='javascript'>");
            out.write("alert('用户注册失败。');");
            out.write("location.href='register.html'");
            out.write("</script>");
            out.flush();
            //resp.sendRedirect("register.html");
            return;
        }else {
            out.write("<script language='javascript'>");
            out.write("alert('用户注册成功。');");
            out.write("location.href='loginPage'");
            out.write("</script>");
            out.flush();
            //resp.sendRedirect("loginPage");
            System.out.println("用户名："+rUsername);
            System.out.println("密码："+rPassword);
            System.out.println("性别："+sex);
            System.out.println("年龄："+age);
            System.out.print("爱好：");
            if(hobby!=null&&hobby.length>0){
                for(int i=0;i<hobby.length;i++){
                    System.out.print(hobby[i]+" ");
                }
            }
        }

    }
}
