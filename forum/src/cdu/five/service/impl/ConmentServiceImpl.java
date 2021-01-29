package cdu.five.service.impl;

import cdu.five.dao.ConmentDao;
import cdu.five.dao.impl.ConmentDaoImpl;
import cdu.five.model.Conment;
import cdu.five.service.ConmentService;

import java.util.List;

public class ConmentServiceImpl implements ConmentService {
    ConmentDao conmentDao = new ConmentDaoImpl();

    public boolean insert(Conment conment) {

        return conmentDao.insert(conment) == 1 ? true : false;

    }

    @Override
    public List<Conment> findByPage(int page, int pageSize, int id) {
        if(page>0){
            return conmentDao.findByPage((page-1)* pageSize,pageSize,id);
        }else {
            return conmentDao.findByPage(0,pageSize,id);
        }
    }

    @Override
    public int getCount(int id) {
        return conmentDao.getCount(id);
    }
}
