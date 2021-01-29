package com.c.pet.service.impl;

import com.c.pet.dao.TbOrderDao;

import com.c.pet.dao.TbSubjectDao;
import com.c.pet.entity.TbOrder;
import com.c.pet.entity.TbSubject;
import com.c.pet.result.ResponseData;
import com.c.pet.service.TbOrderService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbOrder)表服务实现类
 *
 * @author makejava
 * @since 2021-01-20 11:30:26
 */
@Service("tbOrderService")
public class TbOrderServiceImpl implements TbOrderService {
    @Resource
    private TbOrderDao tbOrderDao;


    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    @Override
    public TbOrder queryById(Integer oId) {
        return this.tbOrderDao.queryById(oId);
    }

    /**
     * 查询多条数据
     *
     * @param page  查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public ResponseData queryAllByLimit(Integer page, Integer limit) {
        if (page != null && limit != null) {
            page = (page - 1) * limit;
        } else {
            page = 0;
            limit = 10;
        }
        List<TbOrder> tbOrder = tbOrderDao.queryAllByLimit(page, limit);
        Integer i = tbOrderDao.countById();
        return new ResponseData("0", "success", tbOrder, i);
    }

    /**
     * 新增数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TbOrder insert(TbOrder tbOrder) {
        this.tbOrderDao.insert(tbOrder);
        return tbOrder;
    }

    /**
     * 修改数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TbOrder update(TbOrder tbOrder) {
        this.tbOrderDao.update(tbOrder);
        return this.queryById(tbOrder.getOId());
    }

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer oId) {
        return this.tbOrderDao.deleteById(oId) > 0;
    }

    @Override
    public ResponseData queryByLike(String value, Integer page, Integer limit) {
        if (page != null && limit != null) {
            page = (page - 1) * limit;
        } else {
            page = 0;
            limit = 10;
        }
        Integer i = tbOrderDao.countByLike(value);
        List<TbOrder> TbOrders = tbOrderDao.queryByLike(value, page, limit);
        return new ResponseData("0", "success", TbOrders, i);
    }

    @Override
    public boolean deleteByIdAll(Integer[] oid) {
        int j=0;
        for(Integer i : oid){
            if(tbOrderDao.deleteById(i)>0){
                j++;
            }
        }
        return j>0;
    }

}


