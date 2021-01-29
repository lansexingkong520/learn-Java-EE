package com.c.pet.service;

import com.c.pet.entity.TbSubject;
import com.c.pet.result.ResponseData;

import java.util.List;

/**
 * (TbSubject)表服务接口
 *
 * @author makejava
 * @since 2021-01-20 11:28:45
 */
public interface TbSubjectService {

    /**
     * 通过ID查询单条数据
     *
     * @param suId 主键
     * @return 实例对象
     */
    TbSubject queryById(Integer suId);

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
     * @param tbSubject 实例对象
     * @return 实例对象
     */
    Boolean insert(TbSubject tbSubject);

    /**
     * 修改数据
     *
     * @param tbSubject 实例对象
     * @return 实例对象
     */
    ResponseData update(TbSubject tbSubject);

    /**
     * 通过主键删除数据
     *
     * @param suId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer suId);

    ResponseData queryByLike(String value, Integer page, Integer limit);

    List<TbSubject> queryByTitle(String title);

    boolean deleteByIdAll(Integer[] suId);
}