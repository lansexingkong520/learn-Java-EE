package cdu.yd.biz.util;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@WebServlet("/display")
public class DisplayPhoto extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //禁止缓存
        resp.setHeader("Pragma","no-cache");
        resp.setHeader("Cache-Control","no-cache");
        resp.setDateHeader("Expires",0);
        resp.setContentType("image/png");
        String photoUrl = req.getParameter("photoUrl");
        if(!photoUrl.equals("")){
            String path = getServletConfig().getServletContext().getRealPath("/")+ photoUrl;
            System.out.println(path);
            try{
                BufferedImage bufferedImage = ImageIO.read(new File(path));
                ImageIO.write(bufferedImage,"jpg",resp.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
