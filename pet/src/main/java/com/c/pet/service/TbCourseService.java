package com.c.pet.service;

import com.c.pet.entity.TbCourse;
import com.c.pet.result.ResponseData;

import java.util.List;

/**
 * (TbCourse)表服务接口
 *
 * @author makejava
 * @since 2021-01-20 11:30:16
 */
public interface TbCourseService {

    /**
     * 通过ID查询单条数据
     *
     * @param cId 主键
     * @return 实例对象
     */
    TbCourse queryById(Integer cId);

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
     * @param tbCourse 实例对象
     * @return 实例对象
     */
    Boolean insert(TbCourse tbCourse);

    /**
     * 修改数据
     *
     * @param tbCourse 实例对象
     * @return 实例对象
     */
    ResponseData update(TbCourse tbCourse);

    ResponseData updateAll(TbCourse course);

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer cId);

    ResponseData queryByLike(String value, Integer page, Integer limit);


    boolean deleteByIdAll(Integer[] cid);

    ResponseData queryByLikeTitle(String value);

}