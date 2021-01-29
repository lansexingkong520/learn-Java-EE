package com.c.pet.service.impl;

import com.c.pet.dao.TbUserDao;
import com.c.pet.entity.TbUser;
import com.c.pet.result.ResponseData;
import com.c.pet.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (TbUser)表服务实现类
 *
 * @author makejava
 * @since 2021-01-20 11:28:52
 */
@Service("tbUserService")
public class TbUserServiceImpl implements TbUserService {
    @Resource
    private TbUserDao tbUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    @Override
    public TbUser queryById(Integer uId) {
        return this.tbUserDao.queryById(uId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TbUser> queryAllByLimit(int offset, int limit) {
        return this.tbUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public TbUser insert(TbUser tbUser) {
        this.tbUserDao.insert(tbUser);
        return tbUser;
    }

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public TbUser update(TbUser tbUser) {
        this.tbUserDao.update(tbUser);
        return this.queryById(tbUser.getUId());
    }

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uId) {
        return this.tbUserDao.deleteById(uId) > 0;
    }

    @Override
    public ResponseData login(String username, String password, String code, HttpServletRequest request) {
        //验证code
        String code1 = (String) request.getSession().getAttribute("code");
        if(code1.equalsIgnoreCase(code)){
            TbUser tbUser = tbUserDao.queryByUname(username);
            if(tbUser!=null && tbUser.getPassword().equals(password)){
                request.getSession().setAttribute("user",tbUser);
                return new ResponseData("200","登录成功");
            }else {
                return new ResponseData("202","用户名密码错误");
            }
        }else {
            return new ResponseData("201","验证码错误");
        }
    }

    @Override
    public TbUser queryByUname(String username) {

        return this.tbUserDao.queryByUname(username);
    }
}