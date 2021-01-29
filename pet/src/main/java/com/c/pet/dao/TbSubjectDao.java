package com.c.pet.dao;

import com.c.pet.entity.TbSubject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbSubject)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-20 11:28:45
 */
public interface TbSubjectDao {

    /**
     * 通过ID查询单条数据
     *
     * @param suId 主键
     * @return 实例对象
     */
    TbSubject queryById(Integer suId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbSubject> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbSubject 实例对象
     * @return 对象列表
     */
    List<TbSubject> queryAll(TbSubject tbSubject);

    /**
     * 新增数据
     *
     * @param tbSubject 实例对象
     * @return 影响行数
     */
    int insert(TbSubject tbSubject);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbSubject> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbSubject> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbSubject> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TbSubject> entities);

    /**
     * 修改数据
     *
     * @param tbSubject 实例对象
     * @return 影响行数
     */
    int update(TbSubject tbSubject);

    /**
     * 通过主键删除数据
     *
     * @param suId 主键
     * @return 影响行数
     */
    int deleteById(Integer suId);

    Integer countSub();

    Integer countByLike(String value);

    List<TbSubject> queryByLike(@Param("value") String value,@Param("page") Integer page,@Param("limit") Integer limit);

    List<TbSubject> queryByTitle(String title);

}