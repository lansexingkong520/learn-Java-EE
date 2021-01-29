package com.qf.cdmr.service;

import com.qf.cdmr.entity.Shop;

import java.util.List;

/**
 * (Shop)表服务接口
 *
 * @author makejava
 * @since 2021-01-11 15:53:09
 */
public interface ShopService {

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    Shop queryById(Integer sId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Shop> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    Shop insert(Shop shop);

    /**
     * 修改数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    Shop update(Shop shop);

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer sId);

}