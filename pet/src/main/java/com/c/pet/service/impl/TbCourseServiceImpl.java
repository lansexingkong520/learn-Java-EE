package com.c.pet.service.impl;

import com.c.pet.dao.TbCourseDao;
import com.c.pet.entity.TbCourse;
import com.c.pet.result.ResponseCode;
import com.c.pet.result.ResponseData;
import com.c.pet.service.TbCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (TbCourse)表服务实现类
 *
 * @author makejava
 * @since 2021-01-20 11:30:16
 */
@Service("tbCourseService")
public class TbCourseServiceImpl implements TbCourseService {
    @Resource
    private TbCourseDao tbCourseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cId 主键
     * @return 实例对象
     */
    @Override
    public TbCourse queryById(Integer cId) {
        return this.tbCourseDao.queryById(cId);
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
        List<TbCourse> courses = this.tbCourseDao.queryAllByLimit(page, limit);
        Integer i = tbCourseDao.countCourse();
        return new ResponseData("0", "success", courses, i);
    }

    /**
     * 新增数据
     *
     * @param tbCourse 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(TbCourse tbCourse) {
        Date date = new Date();
        tbCourse.setTime(date);
        return this.tbCourseDao.insert(tbCourse) > 0;
    }

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Transactional
    @Override
    public ResponseData update(TbCourse course) {
        try {
            String field = course.getField();
            String value = course.getValue();
            //判断field的类型
            if (course.getField() != null && course.getField() != "" && value != null) {
                if (field.equals("title")) {
                    course.setTitle((value));
                }
                if (field.equals("message")) {
                    course.setMessage(value);
                }

                int i = this.tbCourseDao.update(course);
                if (i > 0) {
                    return new ResponseData(ResponseCode.SUCCESS);
                } else {
                    return new ResponseData(ResponseCode.FAILED);
                }
            } else {
                int i = this.tbCourseDao.update(course);
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

    @Override
    public ResponseData updateAll(TbCourse course) {
        System.out.println(course.getTitle());
        System.out.println(course.getPId());
        System.out.println(course.getMessage());
        System.out.println(course.getCId());

        Date date = new Date();
        course.setTime(date);
        int i = tbCourseDao.update(course);
        System.out.println(i);
        if (i > 0) {
            return new ResponseData(ResponseCode.SUCCESS);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer cId) {
        return this.tbCourseDao.deleteById(cId) > 0;
    }

    @Override
    public ResponseData queryByLike(String value, Integer page, Integer limit) {
        if (page != null && limit != null) {
            page = (page - 1) * limit;
        } else {
            page = 0;
            limit = 10;
        }
        List<TbCourse> courses = tbCourseDao.queryByLike(value, page, limit);
        Integer i = tbCourseDao.countByLike(value);
        return new ResponseData("0", "success", courses, i);
    }

    @Override
    public boolean deleteByIdAll(Integer[] cid) {
        int j=0;
        for(Integer i : cid){
            if(tbCourseDao.deleteById(i)>0){
                j++;
            }
        }
        return j>0;
    }

    @Override
    public ResponseData queryByLikeTitle(String value) {
        List<TbCourse> courses = tbCourseDao.queryByLikeTitle(value);
        //Integer i = tbCourseDao.countByLike(value);
        return new ResponseData("0", "success", courses);
    }

}