package com.qf.cdmr.controller;

import com.qf.cdmr.entity.Order;
import com.qf.cdmr.result.ResponseData;
import com.qf.cdmr.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2021-01-11 16:25:21
 */
@Api(value = "orderApi")
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    @ApiOperation(value = "createOrder",notes = "添加预约信息")
    @ApiImplicitParam(name = "order")
    @PostMapping("createOrder")
    public ResponseData createOrder(@RequestBody Order order){
        return orderService.insert(order);
    }
    @ApiOperation(value = "queryAll",notes = "获取预约列表")
    @ApiImplicitParam(name = "queryAll")
    @GetMapping("queryAll")
    public ResponseData queryAll(Integer page,Integer limit){
        return orderService.queryAllByLimit(page,limit);
    }
}