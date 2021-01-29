package com.c.pet.controller;

import cn.dsna.util.images.ValidateCode;
import com.c.pet.result.ResponseCode;
import com.c.pet.result.ResponseData;
import com.c.pet.service.TbUserService;
import com.c.pet.util.UpUtils;
import io.swagger.annotations.ApiOperation;

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
    private  TbUserService tbUserService;

    //跳转到图片详情页
    @ApiIgnore
    @RequestMapping("gettbPicDetail")
    public String getPicDetail(){
        return "tbPicdetail";
    }


    //跳转到上传的界面
    @ApiIgnore
    @RequestMapping("getUploadtbPic")
    public String getUploadpic(){
        return "uploadtbpic";
    }


    @ApiOperation(value = "upfile",notes = "上传文件")
    @RequestMapping("upfile")
    @ResponseBody
    public ResponseData upfile(MultipartFile file, HttpServletRequest request){
        //实现文件上传  成功以后返回一个地址
        String url = UpUtils.upfile(file, request);
        if(url!= null){
            return new ResponseData(ResponseCode.SUCCESS,url);
        }else{
            return new ResponseData(ResponseCode.FAILED,url);
        }
    }

    @RequestMapping("getsubDetail")
    public String getSubDetail(){
        return "subDetail";
    }


    @RequestMapping("getMain")
    public String getMain(){
        return "main";
    }

    @RequestMapping("getuploadSub")
    public String getuploadSub(){
        return "uploadSub";
    }
    //跳转到课堂信息页面
    @ApiIgnore
    @RequestMapping("getCourseDetail")
    public String getCourseDetail(){
        return "coursedetail";
    }

    //跳转到修改课堂信息页面
    @ApiIgnore
    @RequestMapping("getModifyCourse")
    public String getModifyCourse(){
        return "modifycourse";
    }

    //跳转到添加课堂页面
    @ApiIgnore
    @RequestMapping("getUploadCourse")
    public String getUploadCourse(){
        return "uploadcourse";
    }

    //跳转到预约信息界面
    @ApiIgnore
    @RequestMapping("getOrder")
    public String getOrder() {
        return "order";
    }


    //返回到主界面
    @ApiIgnore
    @RequestMapping("index1")
    public String index1(){
        return "index1";
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
        return tbUserService.login(username,password,code,request);
    }

    //跳转到批量导入界面
    @ApiIgnore
    @RequestMapping("getImportFile")
    public String getImportFile(){
        return "importfile";
    }
}

