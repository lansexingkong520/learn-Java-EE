package com.qf.cdmr.service;

import com.qf.cdmr.entity.Addr;

import java.util.List;

/**
 * (Addr)表服务接口
 *
 * @author makejava
 * @since 2021-01-11 15:52:16
 */
public interface AddrService {

    /**
     * 通过ID查询单条数据
     *
     * @param aId 主键
     * @return 实例对象
     */
    Addr queryById(Integer aId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Addr> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param addr 实例对象
     * @return 实例对象
     */
    Addr insert(Addr addr);

    /**
     * 修改数据
     *
     * @param addr 实例对象
     * @return 实例对象
     */
    Addr update(Addr addr);

    /**
     * 通过主键删除数据
     *
     * @param aId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer aId);

    List<Addr> queryByUname(String uname);
}