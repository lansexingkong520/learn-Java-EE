package com.qf.cdmr.service;

import com.qf.cdmr.entity.SysUser;
import com.qf.cdmr.result.ResponseData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2021-01-11 15:57:33
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    SysUser queryById(Integer uId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uId);

    ResponseData login(String username, String password, String code, HttpServletRequest request);

}