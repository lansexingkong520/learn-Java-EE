package cdu.yd;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class ParamServlet extends HttpServlet {
    String cdu;
    String major;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=utf-8");
        //res.setCharacterEncoding("utf-8");
        PrintWriter out = res.getWriter();
        ServletContext context = getServletContext();
        ServletConfig config = getServletConfig();

        cdu = context.getInitParameter("cdu");
        major = config.getInitParameter("major");

        out.println("全局初始化参数:" + cdu);
        out.println("局部初始化参数:" + major);
        out.close();
    }
}
