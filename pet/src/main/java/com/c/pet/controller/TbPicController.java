package com.c.pet.controller;


import com.c.pet.entity.TbCourse;
import com.c.pet.entity.TbPic;
import com.c.pet.result.ResponseCode;
import com.c.pet.result.ResponseData;
import com.c.pet.service.TbPicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * (TbPic)表控制层
 *
 * @author makejava
 * @since 2021-01-20 11:28:39
 */
@Api(value = "TbPic")
@RestController
@RequestMapping("tbPic")
public class TbPicController {

    @Autowired //自动装配
    private TbPicService tbPicService;


    //通过图片类型获取图片列表
    @ApiOperation(value = "queryByType",notes = "通过图片的类型获取对应图片列表")
    @ApiImplicitParam(name = "type",value = "图片类型lb-轮播,nav-导航",dataType = "string")
    @GetMapping("queryByType/{type}")
    public ResponseData queryByType(@PathVariable("type") String type){
        List<TbPic> pics =  tbPicService.queryByType(type);
        return new ResponseData(ResponseCode.SUCCESS,pics);
    }

    //获取所有图片列表
    @ApiOperation(value = "queryAll",notes = "获取所有图片列表")
    @GetMapping("queryAll")
    public ResponseData queryAll(Integer page, Integer limit){
        return tbPicService.queryAllByLimit(page,limit);
    }


    //根据id修改图片
    @ApiOperation(value = "updateTbPic",notes = "根据id修改图片状态")
    @PatchMapping("updateTbPic")
    public ResponseData updateTbPic(@RequestBody TbPic tbPic){
        return tbPicService.update(tbPic);
    }

    //根据id删除图片
    @ApiOperation(value = "delTbPic",notes = "根据id删除图片")
    @ApiImplicitParam(name="pid",value="图片的id",dataType = "int")
    @DeleteMapping("delTbPic/{pid}")
    public ResponseData delPic(@PathVariable("pid") Integer pid){
        boolean b = tbPicService.deleteById(pid);
        if(b){
            return new ResponseData(ResponseCode.SUCCESS);
        }else{
            return new ResponseData(ResponseCode.FAILED);
        }
    }

    //根据id删除选中图片
    @ApiOperation(value = "delTbPicAll",notes = "根据id删除选中图片")
    @ApiImplicitParam(name="pics",value="选中行图片的id")
    @PostMapping("delTbPicAll")
    public ResponseData delTbPicAll(@RequestBody List<TbPic> pics){
        Integer[] pid = new Integer[10];
        int i = 0;
        for (TbPic pic : pics) {
            pid[i] = pic.getPId();
            i++;
        }
        boolean b = tbPicService.deleteByIdAll(pid);
        if (b) {
            return new ResponseData(ResponseCode.SUCCESS);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }
    }



    //添加图片
    @ApiOperation(value = "insertPic",notes = "插入图片")
    @ApiImplicitParam(name="pic",value="pic对象")
    @PostMapping("insertPic")
    public ResponseData insertPic(@RequestBody TbPic tbPic){
        boolean b = tbPicService.insert(tbPic);
        if(b){
            return new ResponseData(ResponseCode.SUCCESS);
        }else{
            return new ResponseData(ResponseCode.FAILED);
        }
    }

    //模糊查询
    @ApiOperation(value = "queryByLike",notes = "模糊查询")
    @ApiImplicitParam(name = "value",value = "类型,标题")
    @GetMapping("queryByLike")
    public ResponseData queryByLike(String value,Integer page,Integer limit){
        return  tbPicService.queryByLike(value,page,limit);

    }

    //POI
    @ApiOperation(value = "poi",notes = "批量操作")
    @ApiImplicitParam(name = "poi",value = "excel文件对象")
    @RequestMapping ("poi")
    public ResponseData poi(MultipartFile file){
        return  tbPicService.poi(file);

    }


}