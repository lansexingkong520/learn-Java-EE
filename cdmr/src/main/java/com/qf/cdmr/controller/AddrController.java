package com.qf.cdmr.controller;

import com.qf.cdmr.entity.Addr;
import com.qf.cdmr.result.ResponseCode;
import com.qf.cdmr.result.ResponseData;
import com.qf.cdmr.service.AddrService;
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
 * (Addr)表控制层
 *
 * @author makejava
 * @since 2021-01-11 15:52:16
 */
@Api(value = "addrApi")
@RestController
@RequestMapping("addr")
public class AddrController {
    /**
     * 服务对象
     */
    @Autowired
    private AddrService addrService;

    @ApiOperation(value = "queryByUname",notes = "根据当前微信用户名称获取对应地址信息")
    @ApiImplicitParam(name = "uname",value = "微信名称",dataType = "string")
    @GetMapping("queryByUname/{uname}")
    public ResponseData queryByUname(@PathVariable("uname") String uname){
        List<Addr> addrs = addrService.queryByUname(uname);
        return new ResponseData(ResponseCode.SUCCESS,addrs);
    }


}