package cdu.yd.biz.admin;

import cdu.yd.bean.Candidate;
import cdu.yd.biz.util.BaseMethod;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet("/admin/mod")
public class ModifyCandidateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Candidate candidate = null;

        //保存照片位置
        String path = "/WEB-INF/photo";
        //获取真实对应的地址
        String photoUrl = req.getServletContext().getRealPath(path);
        System.out.println(photoUrl);
        //创建一个基于磁盘文件系统的工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建文件上传处理器
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //解析请求
            List<FileItem> items = upload.parseRequest(req);
            if (!items.isEmpty()) {
                candidate = new Candidate();
            }

            //创建迭代器，准备处理表单数据
            Iterator<FileItem> iterator = items.iterator();
            while (iterator.hasNext()) {
                FileItem item = iterator.next();
                if (item.isFormField()) {
                    if (item.getFieldName().equals("username")) {
                        candidate.setName(item.getString("utf-8"));
//                        candidate.setName(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
                    }
                    if (item.getFieldName().equals("id")) {
                        String sId = item.getString("utf-8");
                        int id = (sId == null || sId.equals("")) ? 0 : Integer.parseInt(sId);
                        candidate.setId(id);
                    }
                } else {
                    String fileName = item.getName();
                    File file = new File(photoUrl + "//" + fileName);
                    item.write(file);

                    candidate.setPhotoUrl(req.getContextPath() + path + "/" + fileName);
                }
            }
        } catch (Exception e) {
            System.out.println("上传文件出错：" + e.getMessage());
        }

        PrintWriter out = resp.getWriter();
        System.out.println(candidate.getId());
        System.out.println(candidate.getName());
        //修改候选人
        if (candidate != null) {

            int rows = BaseMethod.update(candidate);
            if (rows == 1) {
                System.out.println("修改成功：" + candidate);
                out.println("<script>alert('候选人" + candidate.getName() + "修改成功');window.location.href='manage'</script>");
            } else {
                System.out.println("修改失败：" + candidate );
                out.println("<script>alert('候选人" + candidate.getName() + "修改失败');window.location.href='modPre'</script>");
            }

        } else {
            System.out.println("修改失败：" + candidate);
            out.println("<script>alert('候选人修改失败');window.location.href='modPre'</script>");
            ;
        }

    }
}
