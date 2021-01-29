package cdu.five.service.impl;

import cdu.five.dao.PostDao;
import cdu.five.dao.impl.PostDaoImpl;
import cdu.five.model.Post;
import cdu.five.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {

    PostDao postDao = new PostDaoImpl();

    @Override
    public boolean insert(Post post) {

        return postDao.insert(post) == 1 ? true : false;
    }

    @Override
    public List<Post> findByPage(int page, int pageSize) {
        if(page>0){
            return postDao.findByPage((page-1)* pageSize,pageSize);
        }else {
            return postDao.findByPage(0,pageSize);
        }
    }

    @Override
    public int getCount() {
        return postDao.getCount();
    }

    @Override
    public Post queryByPid(int pid) {
        return postDao.queryByPid(pid);
    }

    @Override
    public boolean updatetop(Post post) {
        return postDao.updatetop(post) == 1 ? true : false;
    }

    @Override
    public boolean updateess(Post post) {
        return postDao.updateess(post) == 1 ? true : false;
    }

    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public boolean delete(int id) {
        return postDao.delete(id)==1 ? true : false;
    }

    @Override
    public List<Post> findByPageAndId(int page, int pageSize) {
        if(page>0){
            return postDao.findByPageAndId((page-1)* pageSize,pageSize);
        }else {
            return postDao.findByPageAndId(0,pageSize);
        }
    }
}
