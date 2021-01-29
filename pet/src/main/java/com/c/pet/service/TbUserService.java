package com.c.pet.service;

import com.c.pet.entity.TbUser;
import com.c.pet.result.ResponseData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (TbUser)表服务接口
 *
 * @author makejava
 * @since 2021-01-20 11:28:51
 */
public interface TbUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    TbUser queryById(Integer uId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    TbUser insert(TbUser tbUser);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    TbUser update(TbUser tbUser);

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uId);

    ResponseData login(String username, String password, String code, HttpServletRequest request);

    TbUser queryByUname(String username);
}