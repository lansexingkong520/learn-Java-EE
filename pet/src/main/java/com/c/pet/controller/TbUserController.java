package com.c.pet.controller;

import com.c.pet.entity.TbCourse;
import com.c.pet.entity.TbUser;
import com.c.pet.result.ResponseCode;
import com.c.pet.result.ResponseData;
import com.c.pet.service.TbUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (TbUser)表控制层
 *
 * @author makejava
 * @since 2021-01-20 11:28:52
 */
@RestController
@RequestMapping("tbUser")
public class TbUserController {
    /**
     * 服务对象
     */
    @Resource
    private TbUserService tbUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbUser selectOne(Integer id) {
        return this.tbUserService.queryById(id);
    }

    //通过name查找用户
    @ApiOperation(value = "selectByUname",notes = "插入图片")
    @ApiImplicitParam(name = "username",value = "课程的username",dataType = "string")
    @GetMapping("selectByUname/{username}")
    public ResponseData selectByUname(@PathVariable("username") String username) {
        TbUser user = tbUserService.queryByUname(username);
        return new ResponseData(ResponseCode.SUCCESS,user);
    }

}