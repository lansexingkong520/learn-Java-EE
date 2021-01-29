package com.qf.cdmr.controller;

import com.qf.cdmr.entity.Shop;
import com.qf.cdmr.service.ShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Shop)表控制层
 *
 * @author makejava
 * @since 2021-01-11 15:53:10
 */
@RestController
@RequestMapping("shop")
public class ShopController {
    /**
     * 服务对象
     */
    @Resource
    private ShopService shopService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Shop selectOne(Integer id) {
        return this.shopService.queryById(id);
    }

}