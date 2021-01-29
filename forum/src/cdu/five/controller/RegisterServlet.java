package cdu.five.controller;

import cdu.five.model.User;
import cdu.five.service.UserService;
import cdu.five.service.impl.UserServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

@WebServlet("/user/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user=null;

        //保存照片位置
        String path = "/WEB-INF/photo";
        //获取真实对应的地址
        String photoUrl = req.getServletContext().getRealPath(path);
        System.out.println(photoUrl);
        //创建一个基于磁盘文件系统的工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建文件上传处理器
        ServletFileUpload upload =new ServletFileUpload(factory);
        try {
            //解析请求
            List<FileItem> items = upload.parseRequest(req);
            if(!items.isEmpty()){
                user = new User();
            }

            //创建迭代器，准备处理表单数据
            Iterator<FileItem> iterator = items.iterator();
            while (iterator.hasNext()){
                FileItem item = iterator.next();
                if(item.isFormField()){
                    if(item.getFieldName().equals("name")){
                        user.setName(item.getString("utf-8"));
//                        candidate.setName(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
                    }
                    if(item.getFieldName().equals("pwd")){
                        user.setPwd(item.getString("utf-8"));
                    }
                    if(item.getFieldName().equals("sex")){
                        user.setSex(item.getString("utf-8"));
                    }
                }else {
                    String fileName = item.getName();
                    File file = new File(photoUrl+"//"+fileName);
                    item.write(file);
                    user.setPic(req.getContextPath()+path+"/"+fileName);
                }
            }
        } catch (Exception e) {
            System.out.println("上传文件出错："+e.getMessage());
        }

        PrintWriter out = resp.getWriter();
        UserService userService=new UserServiceImpl();
        User user1=userService.isRegister(user.getName());
        if(user.getName()==null||user.getPwd()==null||user.getName().equals("")||user.getPwd().equals("")){
            out.println("<script>alert('注册失败!信息不能为空！');window.location.href='register.jsp'</script>");
        }else if(user1!=null){
            out.println("<script>alert('注册失败！用户名有一样的了');window.location.href='register.jsp'</script>");
        } else {
            if(!userService.insert(user)){
                out.println("<script>alert('注册失败！');window.location.href='register.jsp'</script>");
            }else{
                HttpSession session = req.getSession();
                session.setAttribute("user",user);
                out.println("<script>alert('注册成功！');window.location.href='/'</script>");
            }
        }
    }
}
