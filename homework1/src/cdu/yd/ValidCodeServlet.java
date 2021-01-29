package cdu.yd;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/validCode")
public class ValidCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //禁止缓存
        resp.setHeader("Pragma","No-cache");
        resp.setHeader("Cache-Control","no-cache");
        resp.setDateHeader("Expires",0);
        //生成验证码
        Random random = new Random();
        String s = "abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ23456789";
        StringBuilder code = new StringBuilder(4);
        for(int i=0;i<4;i++)
        {
            char ch=s.charAt(new Random().nextInt(s.length()));
            code.append(ch);
        }

        //保存验证码
        HttpSession session = req.getSession();
        session.setAttribute("validCode",String.valueOf(code));

        //准备绘制工作
        int width = 80;
        int height = 30;
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        //进行验证码绘制
        g.setColor(new Color(255,245,238,255));
        g.fillRect(0,0,width,height);
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.drawString(String.valueOf(code),2,18);
        //绘制干扰
        //TODO
        //响应图片
        ImageIO.write(img,"PNG",resp.getOutputStream());
    }
}
