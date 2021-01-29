package cdu.yd.biz.admin;

import cdu.yd.biz.util.BaseMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/del")
public class DeleteCandidateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //删除候选人，拿到候选人的id就好了
        String sId = req.getParameter("id");
        int id = (sId == null || sId.equals(""))?0 : Integer.parseInt(sId);
        System.out.println(id);

        //删除数据库候选人
        int rows = BaseMethod.delete(id);
            if(rows==1){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        //跳转回查看候选人列表
        resp.sendRedirect("manage");
    }
}
