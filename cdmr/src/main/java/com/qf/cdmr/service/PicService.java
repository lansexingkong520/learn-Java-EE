package com.qf.cdmr.service;

import com.qf.cdmr.entity.Pic;
import com.qf.cdmr.result.ResponseData;

import java.util.List;

/**
 * (Pic)表服务接口
 *
 * @author makejava
 * @since 2021-01-11 15:43:44
 */
public interface PicService {

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    Pic queryById(Integer pId);

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
     * @param pic 实例对象
     * @return 实例对象
     */
    Boolean insert(Pic pic);

    /**
     * 修改数据
     *
     * @param pic 实例对象
     * @return 实例对象
     */
    ResponseData update(Pic pic);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer pId);

    List<Pic> queryByType(String type);

    ResponseData queryByLike(String value, Integer page, Integer limit);
}