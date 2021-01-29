package cdu.yd.listener;

import cdu.yd.model.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;
import java.util.List;

@WebListener("OnlineListener")
public class OnlineListener implements ServletContextListener, HttpSessionAttributeListener {
    List<User> onlineUser;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        onlineUser = new ArrayList<>();
        sce.getServletContext().setAttribute("online",onlineUser);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        if(se.getName().equals("user")){
            onlineUser.add((User) se.getValue());
        }
        se.getSession().getServletContext().setAttribute("online",onlineUser);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        if(se.getName().equals("user")){
            onlineUser.remove((User) se.getValue());
        }
        se.getSession().getServletContext().setAttribute("online",onlineUser);
    }
}
