package com.qf.cdmr.service.impl;

import com.qf.cdmr.dao.ShopDao;
import com.qf.cdmr.entity.Shop;
import com.qf.cdmr.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Shop)表服务实现类
 *
 * @author makejava
 * @since 2021-01-11 15:53:09
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopDao shopDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    @Override
    public Shop queryById(Integer sId) {
        return this.shopDao.queryById(sId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Shop> queryAllByLimit(int offset, int limit) {
        return this.shopDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    @Override
    public Shop insert(Shop shop) {
        this.shopDao.insert(shop);
        return shop;
    }

    /**
     * 修改数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    @Override
    public Shop update(Shop shop) {
        this.shopDao.update(shop);
        return this.queryById(shop.getSId());
    }

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer sId) {
        return this.shopDao.deleteById(sId) > 0;
    }
}