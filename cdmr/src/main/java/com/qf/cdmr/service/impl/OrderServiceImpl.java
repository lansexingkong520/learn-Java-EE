package com.qf.cdmr.service.impl;

import com.qf.cdmr.dao.AddrDao;
import com.qf.cdmr.dao.OrderDao;
import com.qf.cdmr.entity.Addr;
import com.qf.cdmr.entity.Order;
import com.qf.cdmr.entity.OrderDto;
import com.qf.cdmr.result.ResponseCode;
import com.qf.cdmr.result.ResponseData;
import com.qf.cdmr.service.OrderService;
import com.qf.cdmr.util.SmsUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2021-01-11 16:25:20
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private AddrDao addrDao;
    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Integer oId) {
        return this.orderDao.queryById(oId);
    }

    /**
     * 查询多条数据
     *
     * @param page 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public ResponseData queryAllByLimit(Integer page, Integer limit) {
        if(page != null && limit != null){
            page = (page-1)*limit;
        }else {
            page=0;
            limit=10;
        }
        List<OrderDto> orderDtos = orderDao.queryAllByLimit(page,limit);
        Integer i = orderDao.countById();
        return new ResponseData("0","success",orderDtos,i);
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Transactional
    @Override
    public ResponseData insert(Order order) {
        //进入服务层以后只要对数据库进行数据更改，必须添加事务
        //执行某个过程，要么成功，要么失败
        //事务进行回滚
        try{
            int i = this.orderDao.insert(order);
            if(i>0){
                //发送短信给用户--通过地址id获取到用户的手机号
                Addr addr = addrDao.queryById(order.getAId());
                //发送短信
                Boolean send = SmsUtil.send(addr.getTel());
                if(send){
                    return new ResponseData(ResponseCode.SUCCESS);

                }else {
                    return new ResponseData(ResponseCode.FAILED);
                }
            }else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return new ResponseData(ResponseCode.FAILED);
            }
        }catch (Exception e){
            //将错误信息打印在控制台
            e.printStackTrace();
            //设置事务手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResponseData(ResponseCode.FAILED);
        }
    }

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.update(order);
        return this.queryById(order.getOId());
    }

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer oId) {
        return this.orderDao.deleteById(oId) > 0;
    }
}