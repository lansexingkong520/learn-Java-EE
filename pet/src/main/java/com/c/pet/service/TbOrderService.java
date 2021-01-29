package com.c.pet.service;

import com.c.pet.entity.TbOrder;
import com.c.pet.result.ResponseData;
import org.apache.http.protocol.ResponseDate;

/**
 * (TbOrder)表服务接口
 *
 * @author makejava
 * @since 2021-01-20 11:30:26
 */
public interface TbOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    TbOrder queryById(Integer oId);

    /**
     * 查询多条数据
     *
     * @param page 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    ResponseData queryAllByLimit(Integer page, Integer limit);

    /**
     * 新增数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    TbOrder insert(TbOrder tbOrder);

    /**
     * 修改数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    TbOrder update(TbOrder tbOrder);

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer oId);

    
    ResponseData queryByLike(String value, Integer page, Integer limit);

    boolean deleteByIdAll(Integer[] oid);
}