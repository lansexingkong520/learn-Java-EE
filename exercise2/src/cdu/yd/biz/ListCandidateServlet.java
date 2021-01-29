package cdu.yd.biz;

import cdu.yd.bean.Candidate;
import cdu.yd.biz.util.BaseMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list")
public class ListCandidateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        //分页
        String sPage = req.getParameter("page");
        int page = (sPage == null || sPage.equals("")) ? 1 : Integer.parseInt(sPage);
        int pageSize = 5;
        req.setAttribute("page", page);
        List<Candidate> candidates = new ArrayList<Candidate>();

        //数据库中取出信息
        candidates = BaseMethod.query((page-1)*pageSize,pageSize);

        System.out.println(candidates);
        int userCount=BaseMethod.getCount();
        int pageCount = userCount % pageSize ==0?userCount/pageSize:userCount/pageSize+1;

        //将候选人信息显示在页面上
        out.println("<html><head><title>查看投票结果</title></head><body>");
        out.println("<h1>查看投票结果</h1>");
        out.println("<span><a href='http://localhost:8080/admin/manage'>管理候选人</a></span><br>");
        out.println("<table border = '1'><tr><th>id</th>");
        out.println("<th>姓名</th>");
        out.println("<th>照片</th>");
        out.println("<th>票数</th></tr>");
        if(candidates!=null){
            for (Candidate candidate:candidates){
                out.println("<tr>");
                out.println("<td>" + candidate.getId() + "</td>");
                out.println("<td>" + candidate.getName() + "</td>");
                out.println("<td width='100px'><img src='http://localhost:8080/display?photoUrl=" + candidate.getPhotoUrl() + "' width='100%'></td>");
                out.println("<td>" + candidate.getVotes() + "</td>");
                out.println("<td><a href = 'http://localhost:8080/vote?id="+ candidate.getId()+ "'>投票</a></td>");
                out.println("</tr>");
            }
        }
        out.println("</table>");
        if(page>1){
            out.println("<span><a href='list?page="+(page-1)+"'>上一页</a></span>");
        }
        if(page<pageCount){
            out.println("    <span><a href='list?page="+(page+1)+"'>下一页</a></span>");
        }
        out.println("<span>共"+pageCount+"页</span>");
        out.println("<span>共"+userCount+"人</span>");
        out.println("</body></html>");
        out.println("</body></html>");

    }
}
