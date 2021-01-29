package com.qf.cdmr.service.impl;

import com.qf.cdmr.dao.SysUserDao;
import com.qf.cdmr.entity.SysUser;
import com.qf.cdmr.result.ResponseData;
import com.qf.cdmr.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2021-01-11 15:57:33
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Integer uId) {
        return this.sysUserDao.queryById(uId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return this.sysUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getUId());
    }

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uId) {
        return this.sysUserDao.deleteById(uId) > 0;
    }

    @Override
    public ResponseData login(String username, String password, String code, HttpServletRequest request) {
        //验证code
        String code1 = (String) request.getSession().getAttribute("code");
        if(code1.equalsIgnoreCase(code)){
            SysUser sysUser = sysUserDao.queryByUname(username);
            if(sysUser!=null && sysUser.getPassword().equals(password)){
                request.getSession().setAttribute("user",sysUser);
                return new ResponseData("200","登录成功");
            }else {
                return new ResponseData("202","用户名密码错误");
            }

        }else {
            return new ResponseData("201","验证码错误");
        }
    }
}