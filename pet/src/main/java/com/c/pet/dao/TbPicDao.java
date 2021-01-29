package com.c.pet.dao;

import com.c.pet.entity.TbPic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbPic)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-20 11:28:38
 */
public interface TbPicDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    TbPic queryById(Integer pId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    //当有2个及2个以上的参数时，要使用参数标识，要给每个参数添加上key值
    List<TbPic> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbPic 实例对象
     * @return 对象列表
     */
    List<TbPic> queryAll(TbPic tbPic);

    /**
     * 新增数据
     *
     * @param tbPic 实例对象
     * @return 影响行数
     */
    int insert(TbPic tbPic);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbPic> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbPic> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbPic> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TbPic> entities);

    /**
     * 修改数据
     *
     * @param tbPic 实例对象
     * @return 影响行数
     */
    int update(TbPic tbPic);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 影响行数
     */
    int deleteById(Integer pId);

     List<TbPic> queryByType(@Param("type") String type);

     //查询多条数据
    Integer countPic();

    Integer countByLike(String value);

    List<TbPic> queryByLike(@Param("value") String value, @Param("page") Integer page,@Param("limit") Integer limit);

}