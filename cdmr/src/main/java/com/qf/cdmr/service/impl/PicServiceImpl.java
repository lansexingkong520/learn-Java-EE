package com.qf.cdmr.service.impl;

import com.qf.cdmr.dao.PicDao;
import com.qf.cdmr.entity.Pic;
import com.qf.cdmr.result.ResponseCode;
import com.qf.cdmr.result.ResponseData;
import com.qf.cdmr.service.PicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Pic)表服务实现类
 *
 * @author makejava
 * @since 2021-01-11 15:43:45
 */
@Service("picService")
public class PicServiceImpl implements PicService {
    @Resource
    private PicDao picDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    @Override
    public Pic queryById(Integer pId) {
        return this.picDao.queryById(pId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public ResponseData queryAllByLimit(Integer offset, Integer limit) {
        if(offset != null && limit != null){
            offset = (offset-1)*limit;
        }else {
            offset=0;
            limit=10;
        }

        List<Pic> pics = this.picDao.queryAllByLimit(offset, limit);
        Integer count = picDao.countPic();
        return new ResponseData("0","success",pics,count);
    }

    /**
     * 新增数据
     *
     * @param pic 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(Pic pic) {
        pic.setStatus(0);
        return this.picDao.insert(pic)>0;
    }

    /**
     * 修改数据
     *
     * @param pic 实例对象
     * @return 实例对象
     */
    @Transactional
    @Override
    public ResponseData update(Pic pic) {
        try {
            String field = pic.getField();
            String value = pic.getValue();
            //判断field的类型
            if(pic.getField()!=null&&pic.getField()!=""&&value!=null){
                if(field.equals("title")){
                    pic.setTitle(value);
                }
                if(field.equals("type")){
                    pic.setType(value);
                }
                int i = this.picDao.update(pic);
                if(i>0){
                    return new ResponseData(ResponseCode.SUCCESS);
                }else {
                    return new ResponseData(ResponseCode.FAILED);
                }
            }else {
                int i = this.picDao.update(pic);
                if(i>0){
                    return new ResponseData(ResponseCode.SUCCESS);
                }else {
                    return new ResponseData(ResponseCode.FAILED);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResponseData(ResponseCode.FAILED);
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pId) {
        return this.picDao.deleteById(pId) > 0;
    }

    @Override
    public List<Pic> queryByType(String type) {
        return picDao.queryByType(type);
    }

    @Override
    public ResponseData queryByLike(String value, Integer page, Integer limit) {
        if(page != null && limit != null){
            page = (page-1)*limit;
        }else {
            page=0;
            limit=10;
        }
        List<Pic> pics = picDao.queryByLike(value,page,limit);
        Integer i = picDao.countByLike(value);
        return new ResponseData("0","success",pics,i);
    }
}