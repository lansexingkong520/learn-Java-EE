package com.c.pet.controller;

import com.c.pet.entity.TbCourse;
import com.c.pet.result.ResponseCode;
import com.c.pet.result.ResponseData;
import com.c.pet.service.TbCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.awt.SunHints;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * (TbCourse)表控制层
 *
 * @author makejava
 * @since 2021-01-20 11:30:17
 */
@Api(value = "Course")
@RestController
@RequestMapping("tbCourse")
public class TbCourseController {
    /**
     * 服务对象
     */
    @Autowired
    private  TbCourseService tbCourseService;

    /**
     * 通过主键查询单条数据
     *
     * @param cid 主键
     * @return 单条数据
     */
    //通过id查找单个课程
    @ApiOperation(value = "selectOne",notes = "插入图片")
    @ApiImplicitParam(name = "id",value = "课程的id",dataType = "int")
    @GetMapping("selectOne/{cid}")
    public ResponseData selectOne(@PathVariable("cid") Integer cid) {
        TbCourse course = tbCourseService.queryById(cid);
        return new ResponseData(ResponseCode.SUCCESS,course);
    }

    //插入课程信息
    @ApiOperation(value = "insertCourse",notes = "插入图片")
    @ApiImplicitParam(name = "course",value = "course对象")
    @PostMapping("insertCourse")
    public ResponseData insertCourse(@RequestBody TbCourse course){
        boolean b = tbCourseService.insert(course);
        if(b){
            return  new ResponseData(ResponseCode.SUCCESS);
        }else {
            return  new ResponseData(ResponseCode.FAILED);
        }
    }
    //根据id修改发布的课程的   所有信息
    @ApiOperation(value = "updateCourseAll",notes = "根据id修改发布的课程的所有信息")
    @ApiImplicitParam(name = "course", value = "course对象")
    @PostMapping("updateCourseAll")
    public ResponseData updateCourseAll(@RequestBody TbCourse course){
        return tbCourseService.updateAll(course);
    }

    //获取所有课程列表
    //@CrossOrigin
    @ApiOperation(value = "queryAll",notes = "获取所有课程列表")
    @GetMapping("queryAll")
    public ResponseData queryAll(Integer page,Integer limit){

        return tbCourseService.queryAllByLimit(page, limit);
    }

    //模糊查询
    @ApiOperation(value = "queryByLike",notes = "模糊查询")
    @ApiImplicitParam(name = "value",value = "类型，标题")
    @GetMapping("queryByLike")
    public ResponseData queryByLike(String value, Integer page, Integer limit){
        return tbCourseService.queryByLike(value,page,limit);
    }
    //模糊查询不分页
    @ApiOperation(value = "queryByLikeTitle",notes = "模糊查询")
    @ApiImplicitParam(name = "value",value = "标题")
    @GetMapping("queryByLikeTitle/{title}")
    public ResponseData queryByLikeTitle(@PathVariable("title") String title){
        System.out.println(title);
        if(title!=null&&!title.equals("")){
            return tbCourseService.queryByLikeTitle(title);
        }else {
            System.out.println(title+"为空");
            return tbCourseService.queryAllByLimit(0,10);
        }

    }

    //根据id修改发布的课程的信息
    @ApiOperation(value = "updateCourse",notes = "根据id修改发布的课程的信息")
    @ApiImplicitParam(name = "course", value = "course对象")
    @PatchMapping("updateCourse")
    public ResponseData updateCourse(@RequestBody TbCourse course){
        return tbCourseService.update(course);
    }

    //根据id删除课程
    @ApiOperation(value = "delCourse",notes = "根据id删除课程")
    @ApiImplicitParam(name = "cid",value = "课程的id",dataType = "int")
    @DeleteMapping("delCourse/{cid}")
    public ResponseData delCourse(@PathVariable("cid") Integer cid){
        boolean b = tbCourseService.deleteById(cid);
        if(b){
            return  new ResponseData(ResponseCode.SUCCESS);
        }else {
            return  new ResponseData(ResponseCode.FAILED);
        }
    }

    //根据id删除多个课程
    @ApiOperation(value = "delCourseAll",notes = "根据id删除课程")
    @ApiImplicitParam(name = "courses",value = "多个课程的id")
    @PostMapping("delCourseAll")
    public ResponseData delCourseAll(@RequestBody List<TbCourse> courses) {
        Integer[] cid = new Integer[10];
        int i = 0;
        for (TbCourse course : courses) {
            cid[i] = course.getCId();
            i++;
        }
        boolean b = tbCourseService.deleteByIdAll(cid);
        if (b) {
            return new ResponseData(ResponseCode.SUCCESS);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }
    }
}