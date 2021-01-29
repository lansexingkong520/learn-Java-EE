package cdu.yd.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns={"/*"},initParams = {@WebInitParam(name = "permitUrls", value = "/,/view/login.jsp,/view/login.do,/validCode,/register,/view/register.jsp")})
public class LoginFilter implements Filter {
    String[] permitUrls = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        permitUrls = filterConfig.getInitParameter("permitUrls").split(",");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("LoginFilter:requestURI="+request.getRequestURI());

        //检查当前请求URL是否是未登录也允许访问的URL
        boolean flag = false;
        for(String url : permitUrls){
            if(request.getRequestURI().endsWith(url)){
                flag = true;
            }
        }
        if(flag || request.getSession().getAttribute("user") != null){
            System.out.println("允许登录");
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            System.out.println("不允许登录");
            response.sendRedirect("/");
            //request.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
