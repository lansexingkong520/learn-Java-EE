package com.qf.cdmr.controller;

import com.qf.cdmr.entity.Subject;
import com.qf.cdmr.result.ResponseCode;
import com.qf.cdmr.result.ResponseData;
import com.qf.cdmr.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (Subject)表控制层
 *
 * @author makejava
 * @since 2021-01-11 16:26:49
 */
@Api(value = "subjectApi")
@RestController
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @ApiOperation(value = "queryByTitle" ,notes = "根据标题查找项目")
    @ApiImplicitParam(name = "title",value = "项目名称",dataType = "string")
    @GetMapping("queryByTitle/{title}")
    public ResponseData queryByTitle(@PathVariable("title") String title){
        List<Subject> subjects =  subjectService.queryByTitle(title);
        return new ResponseData(ResponseCode.SUCCESS,subjects);
    }

    @ApiOperation(value = "queryById" ,notes = "根据id查找项目")
    @ApiImplicitParam(name = "id",value = "项目id",dataType = "int")
    @GetMapping("queryById/{id}")
    public ResponseData queryById(@PathVariable("id") Integer id){
        Subject subject =  subjectService.queryById(id);
        return new ResponseData(ResponseCode.SUCCESS,subject);
    }
}