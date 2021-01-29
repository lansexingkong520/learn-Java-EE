package com.qf.cdmr.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class UpUtils {

    public static String upfile(MultipartFile file, HttpServletRequest request) {
        //获取文件命名
        //判断当前文件类型，并且设置存放路径
        //判断存放路径是否存在，如果不存在，则自动创建
        //创建文件输出流
        //调用write()通过二进制的方式写入对应文件中
        //flush
        //关闭流close


        //获取当前文件的名称
        String originalFilename = file.getOriginalFilename();
        //判断当前文件是什么类型
        String realPath = "";
        String localPath = "";
        String s = "";


        if (originalFilename.endsWith(".mp4")) {
            realPath = request.getSession().getServletContext().getRealPath("/video/");
            localPath ="E:\\IdeaProjects\\cdmr\\src\\main\\resources\\static\\video\\";
            s="http://localhost:8080/video/";

        } else if (originalFilename.endsWith(".jpg") || originalFilename.endsWith(".png") || originalFilename.endsWith(".jpeg")) {
            realPath = request.getSession().getServletContext().getRealPath("/img/");
            localPath ="E:\\IdeaProjects\\cdmr\\src\\main\\resources\\static\\img\\";
            s="http://localhost:8080/img/";

        } else if (originalFilename.endsWith(".mp3")) {
            realPath = request.getSession().getServletContext().getRealPath("/audio/");
            localPath ="E:\\IdeaProjects\\cdmr\\src\\main\\resources\\static\\audio\\";
            s="http://localhost:8080/audio/";

        }
        //创建服务器文件对象
        File file1 = new File(realPath);
        //判定当前文件是否存在，不存在则创建
        if (!file1.exists()) {
            file1.mkdirs();
        }

        //创建服务器文件对象
        File file2 = new File(localPath);
        //判定当前文件是否存在，不存在则创建
        if (!file2.exists()) {
            file2.mkdirs();
        }
        FileOutputStream fos = null;
        FileOutputStream fos1 = null;
        try {
            //http://localhost:8080/music-web/video/a.mp4
            // true 表示文件追加   如果为false  则文件夹中永远只有一个文件(左后上传的)
            fos = new FileOutputStream(realPath + originalFilename, true);
            fos.write(file.getBytes());
            fos.flush();
            fos1 = new FileOutputStream(localPath + originalFilename, true);
            fos1.write(file.getBytes());
            fos1.flush();

            return s+originalFilename;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } finally {
            try {
                fos.close();
                fos1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
