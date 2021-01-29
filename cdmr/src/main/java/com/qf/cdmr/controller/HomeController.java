package com.qf.cdmr.controller;

import cn.dsna.util.images.ValidateCode;
import com.qf.cdmr.result.ResponseCode;
import com.qf.cdmr.result.ResponseData;
import com.qf.cdmr.service.SysUserService;
import com.qf.cdmr.util.UpUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private SysUserService sysUserService;

    //跳转到图片详情页
    @ApiIgnore
    @RequestMapping("getPicDetail")
    public String getPicDetail(){
        return "picdetail";
    }

    //跳转到主页面
    @ApiIgnore
    @RequestMapping("getMain")
    public String getMain(){
        return "main";
    }

    //跳转到预约界面
    @ApiIgnore
    @RequestMapping("getOrder")
    public String getOrder(){
        return "order";
    }

    //跳转到上传的界面
    @ApiIgnore
    @RequestMapping("getUploadpic")
    public String getUploadpic(){
        return "uploadpic";
    }

    @ApiOperation(value = "upfile" ,notes = "上传文件")
    @RequestMapping("upfile")
    @ResponseBody
    public ResponseData upfile(MultipartFile file, HttpServletRequest request) {
        //实现文件上传，成功后返回一个地址
        String url = UpUtils.upfile(file, request);
        if(url!=null){
            return new ResponseData(ResponseCode.SUCCESS,url);
        }else {
            return new ResponseData(ResponseCode.FAILED,url);
        }
    }

    @ApiOperation(value ="getCode" ,notes = "获取验证码")
    @GetMapping("/getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response){
        ValidateCode validateCode = new ValidateCode(160,40,4,30);
        //前端输入验证码  后台验证
        String code = validateCode.getCode();
        request.getSession().setAttribute("code",code);
        request.getSession().setMaxInactiveInterval(300);
        try {
            validateCode.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "login",notes = "登录验证")
    @GetMapping("login")
    @ResponseBody
    public ResponseData login(String username,String password,String code,HttpServletRequest request){
        return sysUserService.login(username,password,code,request);
    }

    //返回到主界面
    @ApiIgnore
    @RequestMapping("index1")
    public String index1(){
        return "index1";
    }
}
