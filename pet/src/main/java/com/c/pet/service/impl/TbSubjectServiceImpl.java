package com.c.pet.service.impl;

import com.c.pet.dao.TbSubjectDao;
import com.c.pet.entity.TbSubject;
import com.c.pet.result.ResponseCode;
import com.c.pet.result.ResponseData;
import com.c.pet.service.TbSubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbSubject)表服务实现类
 *
 * @author makejava
 * @since 2021-01-20 11:28:45
 */
@Service("tbSubjectService")
public class TbSubjectServiceImpl implements TbSubjectService {
    @Resource
    private TbSubjectDao tbSubjectDao;

    /**
     * 通过ID查询单条数据
     *
     * @param suId 主键
     * @return 实例对象
     */
    @Override
    public TbSubject queryById(Integer suId) {
        return this.tbSubjectDao.queryById(suId);
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
        if(offset !=null &&limit != null){
            offset = (offset-1)*limit;
        }else {
            offset = 0;
            limit = 10;

        }
        List<TbSubject> tbSubjects = this.tbSubjectDao.queryAllByLimit(offset, limit);
        Integer count = tbSubjectDao.countSub();
        return new ResponseData("0","success",tbSubjects,count);
    }

    /**
     * 新增数据
     *
     * @param tbSubject 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(TbSubject tbSubject) {
        return this.tbSubjectDao.insert(tbSubject)>0;
    }

    /**
     * 修改数据
     *
     * @param tbSubject 实例对象
     * @return 实例对象
     */
    @Override
    public ResponseData update(TbSubject tbSubject) {
        try {
            String field = tbSubject.getField();
            String value = tbSubject.getValue();
            //判断field类型
            if (field != null && field != "" && value != null) {
                if (field.equals("title")) {
                    tbSubject.setTitle(value);
                }
                if (field.equals("name")) {
                    tbSubject.setName(value);
                }
                if (field.equals("detail")) {
                    tbSubject.setDetail(value);
                }
                if (field.equals("rep")) {
                    tbSubject.setRep(value);
                }
                if (field.equals("price")) {
                    float p = Float.valueOf(value);
                    tbSubject.setPrice(p);
                }
                int i = this.tbSubjectDao.update(tbSubject);
                if (i > 0) {
                    return new ResponseData(ResponseCode.SUCCESS);
                } else {
                    return new ResponseData(ResponseCode.FAILED);
                }
            } else {
                int i = this.tbSubjectDao.update(tbSubject);
                if (i > 0) {
                    return new ResponseData(ResponseCode.SUCCESS);
                } else {
                    return new ResponseData(ResponseCode.FAILED);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResponseData(ResponseCode.FAILED);
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param suId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer suId) {
        return this.tbSubjectDao.deleteById(suId) > 0;
    }

    @Override
    public ResponseData queryByLike(String value, Integer page, Integer limit) {
        if(page !=null &&limit != null){
            page = (page-1)*limit;
        }else {
            page = 0;
            limit = 10;
        }
        Integer i = tbSubjectDao.countByLike(value);
        List<TbSubject> tbSubjects = tbSubjectDao.queryByLike(value,page,limit);
        return new ResponseData("0","success",tbSubjects,i);
    }

    @Override
    public List<TbSubject> queryByTitle(String title) {
        return tbSubjectDao.queryByTitle(title);
    }

    @Override
    public boolean deleteByIdAll(Integer[] suId) {
        int j=0;
        for(Integer i : suId){
            if(tbSubjectDao.deleteById(i)>0){
                j++;
            }
        }
        return j>0;
    }

}