package cdu.five.service;

import cdu.five.model.Conment;

import java.util.List;

public interface ConmentService {
    List<Conment> findByPage(int page, int pageSize,int id);

    int getCount(int id);
}
