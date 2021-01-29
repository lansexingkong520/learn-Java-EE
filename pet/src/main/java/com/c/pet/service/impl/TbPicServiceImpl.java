package com.c.pet.service.impl;

import com.c.pet.dao.TbPicDao;
import com.c.pet.entity.TbPic;
import com.c.pet.result.ResponseCode;
import com.c.pet.result.ResponseData;
import com.c.pet.service.TbPicService;

import org.apache.http.protocol.ResponseDate;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * (TbPic)表服务实现类
 *
 * @author makejava
 * @since 2021-01-20 11:28:39
 */
@Service("tbPicService")
public class TbPicServiceImpl implements TbPicService {
    @Resource
    private TbPicDao tbPicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    @Override
    public TbPic queryById(Integer pId) {
        return this.tbPicDao.queryById(pId);
    }

    /**
     * 新增数据
     *
     * @param tbPic 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(TbPic tbPic) {
        tbPic.setStatus(0);
        return this.tbPicDao.insert(tbPic) > 0;
    }

    /**
     * 修改数据
     *
     * @param tbPic 实例对象
     * @return 实例对象
     * 更新图片
     */
    @Override
    public ResponseData update(TbPic tbPic) {
        try {
            String field = tbPic.getField();
            String value = tbPic.getValue();

            //判断field的类型
            if (field != null && field != "" && value != null) {
                if (field.equals("title")) {
                    tbPic.setTitle(value);
                }
                if (field.equals("type")) {
                    tbPic.setType(value);
                }

                int i = this.tbPicDao.update(tbPic);
                if (i > 0) {
                    return new ResponseData(ResponseCode.SUCCESS);
                } else {
                    return new ResponseData(ResponseCode.FAILED);
                }
            } else {
                int i = this.tbPicDao.update(tbPic);
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
     * @param pId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pId) {
        return this.tbPicDao.deleteById(pId) > 0;
    }

    @Override
    public List<TbPic> queryByType(String type) {
        return tbPicDao.queryByType(type);
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
        if (offset != null & limit != null) {
            offset = (offset - 1) * limit;
        } else {
            offset = 0;         //offset=1，0是下标
            limit = 10;
        }
        List<TbPic> pics = this.tbPicDao.queryAllByLimit(offset, limit);
        Integer count = tbPicDao.countPic();
        return new ResponseData("0", "success", pics, count);

    }


    //模糊查询
    @Override
    public ResponseData queryByLike(String value, Integer page, Integer limit) {
        if (page != null && limit != null) {
            page = (page - 1) * limit;
        } else {
            page = 0;
            limit = 10;

        }
        Integer i = tbPicDao.countByLike(value);

        List<TbPic> pics = tbPicDao.queryByLike(value, page, limit);
        return new ResponseData("0", "success", pics, i);
    }

    @Override
    public boolean deleteByIdAll(Integer[] pid) {
        int j = 0;
        for (Integer i : pid) {
            if (tbPicDao.deleteById(i) > 0) {
                j++;
            }
        }
        return j > 0;
    }

    @Override
    public ResponseData poi(MultipartFile file) {
        //判断文件是否为空  不能使用file == null
        if (file.getSize() == 0) {
            return new ResponseData(ResponseCode.FileEmpty);
        }
        //创建excel对象   ---将excel文件转化为java对象(类似于 new file())
        Workbook workbook = null;
        try {
            //判断当前文件为新版本的excel
            if (file.getOriginalFilename().endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(file.getInputStream());
            } else if (file.getOriginalFilename().endsWith(".xls")) {
                //判断当前文件为旧版本的excel
                workbook = new HSSFWorkbook(file.getInputStream());
            } else {
                //当文件不是excel的时候,返回文件类型错误
                return new ResponseData(ResponseCode.FileType);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
            //当file.getInputStream() 发生io错误时,返回未知异常
            return new ResponseData("000404", "未知异常");
        }

        //选中excel文件中第一张表 (下标为零)
        Sheet sheet = workbook.getSheetAt(0);
        //对当前表进行数据验证   获取数据最后一行的下标(第一行不能算作数据) 所以下标必须判断<1
        if (sheet.getLastRowNum() < 1) {
            return new ResponseData("000405", "没有数据");
        }
        //list用来存放解析后的数据    (一行数据为一个java对象)
        List<TbPic> list = new ArrayList<>();
        //for循环遍历表格的行
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            //获取到第一行数据对象
            Row row = sheet.getRow(i);
            //判断当前行为空的情况  跳过本次循环,进行下一次循环
            if(row == null){
                continue;
            }


            //获取当前行的列(index从0开始)     row.getCell(0);
            //表格有几列就写几个
            String title = (String) getValue(row.getCell(0));
            String url = (String) getValue(row.getCell(1));
            String type = (String) getValue(row.getCell(2));

            //将得到的数据封装到java对象中
            TbPic tbpic =new TbPic();
            tbpic.setTitle(title);
            tbpic.setType(type);
            tbpic.setUrl(url);
            tbpic.setStatus(0);
            list.add(tbpic);

        }
        try {
            //没有办法精确到哪一行数据出问题
            tbPicDao.insertBatch(list);
            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResponseData(ResponseCode.FAILED);
        }

    }
    //POI工具
    private static Object getValue(Cell cell) {
        Object object = null;
        switch (cell.getCellTypeEnum()) {
            case STRING:
                object = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    object = cell.getDateCellValue();
                } else {
                    object = cell.getNumericCellValue();
                }
                break;
            case BOOLEAN:
                object = cell.getBooleanCellValue();
            case BLANK:
                break;
            case FORMULA:
                //公式型
                object = cell.getCellFormula();
                break;
            default:
                object = null;

        }
        return object;
    }

}