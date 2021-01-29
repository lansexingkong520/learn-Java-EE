package com.c.pet.dao;

import com.c.pet.entity.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbUser)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-20 11:28:51
 */
public interface TbUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    TbUser queryById(Integer uId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbUser 实例对象
     * @return 对象列表
     */
    List<TbUser> queryAll(TbUser tbUser);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int insert(TbUser tbUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbUser> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TbUser> entities);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int update(TbUser tbUser);

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 影响行数
     */
    int deleteById(Integer uId);

    TbUser queryByUname(String uname);
}