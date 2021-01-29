package com.qf.cdmr.dao;

import com.qf.cdmr.entity.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Subject)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-11 16:26:46
 */
public interface SubjectDao {

    /**
     * 通过ID查询单条数据
     *
     * @param suId 主键
     * @return 实例对象
     */
    Subject queryById(Integer suId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Subject> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param subject 实例对象
     * @return 对象列表
     */
    List<Subject> queryAll(Subject subject);

    /**
     * 新增数据
     *
     * @param subject 实例对象
     * @return 影响行数
     */
    int insert(Subject subject);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Subject> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Subject> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Subject> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Subject> entities);

    /**
     * 修改数据
     *
     * @param subject 实例对象
     * @return 影响行数
     */
    int update(Subject subject);

    /**
     * 通过主键删除数据
     *
     * @param suId 主键
     * @return 影响行数
     */
    int deleteById(Integer suId);

    List<Subject> queryByTitle(@Param("title") String title);
}