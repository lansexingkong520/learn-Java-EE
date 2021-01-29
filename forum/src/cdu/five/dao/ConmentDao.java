package cdu.five.dao;

import cdu.five.model.Conment;

import java.util.List;

public interface ConmentDao {
    int insert(Conment conment);

    List<Conment> findByPage(int start, int num,int id);

    int getCount(int id);
}
