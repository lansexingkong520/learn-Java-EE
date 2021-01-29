package cdu.five.service;

import cdu.five.model.Post;

import java.util.List;

public interface PostService {

    boolean insert(Post post);

    List<Post> findByPage(int page, int pageSize);

    int getCount();

    Post queryByPid(int pid);

    boolean updatetop(Post post);

    boolean updateess(Post post);

    List<Post> findAll();

    boolean delete(int id);

    List<Post> findByPageAndId(int page, int pageSize);

}
