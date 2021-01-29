package cdu.yd.biz;

import cdu.yd.biz.util.BaseMethod;
import cdu.yd.biz.util.GetIp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String ip = GetIp.getRemortIP(req);
        if(!BaseMethod.checkIp(ip)){
            String sId = req.getParameter("id");
            int id = (sId == null || sId.equals("")) ? 0 : Integer.parseInt(sId);
            //投票
            if (id != 0) {
                int rows = BaseMethod.updateVote(id);
                if (rows == 1) {
                    BaseMethod.insertIp(ip);
                    System.out.println("投票成功");
                    out.println("<script>alert('候选人" + id + "投票成功');window.location.href='list'</script>");
                } else {
                    System.out.println("投票失败：" + id);
                    out.println("<script>alert('候选人" + id + "投票失败');window.location.href='list'</script>");
                }
            } else {
                out.println("<script>alert('候选人投票失败" + id + "id未获取成功');window.location.href='list'</script>");
            }
        }else{
            if(BaseMethod.checkStatus(ip)){
                String sId = req.getParameter("id");
                int id = (sId == null || sId.equals("")) ? 0 : Integer.parseInt(sId);
                //投票
                if (id != 0) {
                    int rows = BaseMethod.updateVote(id);
                    if (rows == 1) {
                        BaseMethod.updateStatus(ip);
                        System.out.println("投票成功");
                        out.println("<script>alert('候选人" + id + "投票成功');window.location.href='list'</script>");
                    } else {
                        System.out.println("投票失败：" + id);
                        out.println("<script>alert('候选人" + id + "投票失败');window.location.href='list'</script>");
                    }
                } else {
                    out.println("<script>alert('候选人投票失败" + id + "id未获取成功');window.location.href='list'</script>");
                }
            }else {
                out.println("<script>alert('投票失败,您今天已经投过票');window.location.href='list'</script>");
            }
        }

//0

    }
}
