package com.jzheng.mapper;

import com.jzheng.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int insertBlog(Blog blog);

    List<Blog> queryBlogIf(Blog blog);

    List<Blog> queryBlogWhen(Blog blog);

    List<Blog> queryBlogWhere(Blog blog);

    int updateBlog(Blog blog);

    List<Blog> queryBlogIn(Map map);

    List<Blog> queryBlogIfScript(Map map);
}
