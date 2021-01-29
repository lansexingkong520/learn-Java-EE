package com.qf.cdmr.dao;

import com.qf.cdmr.entity.Addr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Addr)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-11 15:52:16
 */
public interface AddrDao {

    /**
     * 通过ID查询单条数据
     *
     * @param aId 主键
     * @return 实例对象
     */
    Addr queryById(Integer aId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Addr> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param addr 实例对象
     * @return 对象列表
     */
    List<Addr> queryAll(Addr addr);

    /**
     * 新增数据
     *
     * @param addr 实例对象
     * @return 影响行数
     */
    int insert(Addr addr);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Addr> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Addr> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Addr> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Addr> entities);

    /**
     * 修改数据
     *
     * @param addr 实例对象
     * @return 影响行数
     */
    int update(Addr addr);

    /**
     * 通过主键删除数据
     *
     * @param aId 主键
     * @return 影响行数
     */
    int deleteById(Integer aId);

    List<Addr> queryByUname(Integer uid);
}