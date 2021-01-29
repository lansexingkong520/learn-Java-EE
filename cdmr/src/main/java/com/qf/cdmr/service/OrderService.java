package com.qf.cdmr.service;

import com.qf.cdmr.entity.Order;
import com.qf.cdmr.result.ResponseData;

import java.util.List;

/**
 * (Order)表服务接口
 *
 * @author makejava
 * @since 2021-01-11 16:25:19
 */
public interface OrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    Order queryById(Integer oId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    ResponseData queryAllByLimit(Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    ResponseData insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer oId);

}