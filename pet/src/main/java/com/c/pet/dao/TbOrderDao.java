package com.c.pet.dao;

import com.c.pet.entity.TbOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbOrder)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-20 11:30:25
 */
public interface TbOrderDao {


    Integer countByLike(String value);
    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    TbOrder queryById(Integer oId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbOrder> queryAllByLimit(@Param("offset") Integer offset, @Param("limit") Integer limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbOrder 实例对象
     * @return 对象列表
     */
    List<TbOrder> queryAll(TbOrder tbOrder);

    /**
     * 新增数据
     *
     * @param tbOrder 实例对象
     * @return 影响行数
     */
    int insert(TbOrder tbOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbOrder> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TbOrder> entities);

    /**
     * 修改数据
     *
     * @param tbOrder 实例对象
     * @return 影响行数
     */
    int update(TbOrder tbOrder);

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 影响行数
     */
    int deleteById(Integer oId);
    Integer countById();

    List<TbOrder> queryByLike(@Param("value") String value, @Param("page") Integer page, @Param("limit") Integer limit);
}