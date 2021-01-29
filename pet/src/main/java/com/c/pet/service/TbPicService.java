package com.c.pet.service;

import com.c.pet.entity.TbPic;
import com.c.pet.entity.TbSubject;
import com.c.pet.result.ResponseData;
import org.apache.http.protocol.ResponseDate;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

/**
 * (TbPic)表服务接口
 *
 * @author makejava
 * @since 2021-01-20 11:28:38
 */
public interface TbPicService {
    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    TbPic queryById(Integer pId);

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
     * @param tbPic 实例对象
     * @return 实例对象
     */
    Boolean insert(TbPic tbPic);

    /**
     * 修改数据
     *
     * @param tbPic 实例对象
     * @return 实例对象
     */
    ResponseData update(TbPic tbPic);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer pId);

    List<TbPic> queryByType(String type);

    ResponseData queryByLike(String value, Integer page, Integer limit);

    boolean deleteByIdAll(Integer[] pid);

    ResponseData poi(MultipartFile file);
}