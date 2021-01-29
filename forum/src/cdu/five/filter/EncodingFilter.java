package cdu.five.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter",urlPatterns={"/*"})
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        System.out.println("EncodingFilter:requestURL="+req.getRequestURI());

        if(req.getMethod().equals("GET")){
            req = new EncodingWrapper(req);
        }else {
            req.setCharacterEncoding("utf-8");
        }
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(req,resp);
    }

}
