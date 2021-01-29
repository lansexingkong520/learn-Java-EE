package com.c.pet.controller;

import com.c.pet.entity.TbOrder;
import com.c.pet.entity.TbPic;
import com.c.pet.entity.TbSubject;
import com.c.pet.result.ResponseCode;
import com.c.pet.result.ResponseData;
import com.c.pet.service.TbOrderService;
import com.c.pet.service.TbSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbOrder)表控制层
 *
 * @author makejava
 * @since 2021-01-20 11:30:26
 */
@Api(value = "orderApi")
@RestController
@RequestMapping("tbOrder")
public class TbOrderController {
    @Resource
    private TbOrderService TbOrderService;
    @Resource
    private TbSubjectService subjectService;

    @ApiOperation(value = "createOrder", notes = "添加预约信息")
    @PostMapping("createOrder")
    public TbOrder createOrder(@RequestBody TbOrder tbOrder) {
        Integer suId = tbOrder.getSuId();
        TbSubject subject = subjectService.queryById(suId);
        String suname = subject.getName();
        tbOrder.setSuname(suname);
        return TbOrderService.insert(tbOrder);
    }


   //删除预约
    @ApiOperation(value = "delOrder", notes = "根据id删除预约")
    @ApiImplicitParam(name = "oid", value = "订单的id", dataType = "int")
    @DeleteMapping("delOrder/{oid}")
    public ResponseData delOrder(@PathVariable("oid") Integer oid) {
        boolean b = TbOrderService.deleteById(oid);
        if (b) {
            return new ResponseData(ResponseCode.SUCCESS);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }
    }

    //根据id删除选中预约
    @ApiOperation(value = "delOrderAll",notes = "根据id删除选中预约")
    @ApiImplicitParam(name="pics",value="选中行预约的id")
    @PostMapping("delOrderAll")
    public ResponseData delOrderAll(@RequestBody List<TbOrder> orders){
        Integer[] oid = new Integer[10];
        int i = 0;
        for (TbOrder order : orders) {
            oid[i] = order.getOId();
            i++;
        }
        boolean b = TbOrderService.deleteByIdAll(oid);
        if (b) {
            return new ResponseData(ResponseCode.SUCCESS);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }
    }

   //查询所有
    @ApiOperation(value = "queryAll", notes = "获取预约列表")
    @GetMapping("queryAll")
    public ResponseData createOrder(Integer page, Integer limit) {
        return TbOrderService.queryAllByLimit(page, limit);
    }


    //分页查询
    @ApiOperation(value = "queryAllByLimit", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页的条数", dataType = "int")
    })
    @GetMapping("queryAllByLimit/{page}/{limit}")
    public ResponseData queryAllByLitmit(@PathVariable("page") Integer page, @PathVariable("limit") Integer limit) {
        return TbOrderService.queryAllByLimit(page, limit);
    }



    //通过用户姓名或项目名做模糊查询
    @ApiOperation(value = "queryByLike",notes = "模糊查询")
    @ApiImplicitParam(name = "value",value = "项目名,用户名")
    @GetMapping("queryByLike")
    public ResponseData queryByLike(String value, Integer page, Integer limit){
        return  TbOrderService.queryByLike(value,page,limit);

    }

}

