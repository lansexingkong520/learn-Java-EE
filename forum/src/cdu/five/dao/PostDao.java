package cdu.five.dao;

import cdu.five.model.Post;

import java.util.List;

public interface PostDao {

    int insert(Post post);

    List<Post> findByPage(int start, int num);

    List<Post> findByPageAndId(int start, int num);

    int getCount();

    Post queryByPid(int pid);

    int updatetop(Post post);

    int updateess(Post post);

    List<Post> findAll();

    int delete(int id);
}
