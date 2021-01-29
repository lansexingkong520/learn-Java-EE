package cdu.yd;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Properties;

public class PropServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Properties properties = new Properties();
        InputStream inputStream = PropServlet.class.getResourceAsStream("/cdu.properties");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        properties.load(reader);
        String name = properties.getProperty("cdu.name");
        String tel = properties.getProperty("college.tel");

        int width = 800;
        int hight = 400;
        BufferedImage image = new BufferedImage(width,hight,BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(new Color(255,255,255,255));
        g.fillRect(0,0,width,hight);
        g.setColor(Color.red);
        g.setFont(new Font("楷体",Font.BOLD,150));
        g.drawString(name,0,160);
        g.drawString(tel,0,320);
        ImageIO.write(image,"PNG",res.getOutputStream());

    }
}
