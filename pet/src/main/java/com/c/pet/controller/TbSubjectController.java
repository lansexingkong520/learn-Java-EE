package com.c.pet.controller;



import com.c.pet.entity.TbPic;
import com.c.pet.entity.TbSubject;
import com.c.pet.result.ResponseCode;
import com.c.pet.result.ResponseData;
import com.c.pet.service.TbSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbSubject)表控制层
 *
 * @author makejava
 * @since 2021-01-20 11:28:45
 */
@Api(value = "TbSubject")
@RestController
@RequestMapping("tbSubject")
public class TbSubjectController {
    @Resource
    private TbSubjectService tbSubjectService;

    //显示列表
    @ApiOperation(value = "queryAll", notes = "获取所有项目列表")
    @GetMapping("queryAll")
    public ResponseData queryAll(Integer page, Integer limit) {
        return tbSubjectService.queryAllByLimit(page, limit);
    }

    //删除
    @ApiOperation(value = "delSub", notes = "删除项目")
    @ApiImplicitParam(name = "suId", value = "项目id", dataType = "int")
    @DeleteMapping("delSub/{suId}")
    public ResponseData delSub(@PathVariable("suId") Integer suId) {
        boolean b = tbSubjectService.deleteById(suId);
        if (b) {
            return new ResponseData(ResponseCode.SUCCESS);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }
    }

    //修改
    @ApiOperation(value = "updateSub", notes = "修改")
    @PatchMapping("updateSub")
    public ResponseData updateSub(@RequestBody TbSubject tbSubject) {
        return tbSubjectService.update(tbSubject);
    }

    //模糊查询
    @ApiOperation(value = "queryByLike", notes = "模糊查询")
    @ApiImplicitParam(name = "value", value = "项目名,标题")
    @GetMapping("queryByLike")
    public ResponseData queryByLike(String value, Integer page, Integer limit) {
        return tbSubjectService.queryByLike(value, page, limit);
    }

    //添加
    @ApiOperation(value = "insertSub", notes = "添加项目")
    @ApiImplicitParam(name = "tbSubject", value = "项目对象")
    @PostMapping("insertSub")
    public ResponseData insertSub(@RequestBody TbSubject tbSubject) {
        boolean b = tbSubjectService.insert(tbSubject);
        if (b) {
            return new ResponseData(ResponseCode.SUCCESS);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }
    }

    //通过title搜
    @ApiOperation(value = "queryByTitle", notes = "通过图片类型获取图片列表")
    @ApiImplicitParam(name = "title", value = "项目标题绝育，疫苗，体检，美容，推荐", dataType = "string")
    @GetMapping("queryByTitle/{title}")
    public ResponseData queryByType(@PathVariable("title") String title) {
        List<TbSubject> tbSubjects = tbSubjectService.queryByTitle(title);
        return new ResponseData(ResponseCode.SUCCESS, tbSubjects);
    }

    //根据id获取图片
    @ApiOperation(value = "queryById", notes = "根据id获取项目")
    @ApiImplicitParam(name = "id", value = "项目id", dataType = "int", required = true)
    @GetMapping("queryById/{id}")
    public ResponseData queryById(@PathVariable("id") Integer id) {
//        PicService picService = new PicServiceImpl();
        TbSubject tbSubject = tbSubjectService.queryById(id);
        return new ResponseData(ResponseCode.SUCCESS, tbSubject);
    }

    //根据id删除选中项目
    @ApiOperation(value = "delSubAll",notes = "根据id删除选中项目")
    @ApiImplicitParam(name="subjects",value="选中行项目的id")
    @PostMapping("delSubAll")
    public ResponseData delSubAll(@RequestBody List<TbSubject> subjects){
        Integer[] suId = new Integer[10];
        int i = 0;
        for (TbSubject subject : subjects) {
            suId[i] = subject.getPId();
            i++;
        }
        boolean b = tbSubjectService.deleteByIdAll(suId);
        if (b) {
            return new ResponseData(ResponseCode.SUCCESS);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }
    }
}