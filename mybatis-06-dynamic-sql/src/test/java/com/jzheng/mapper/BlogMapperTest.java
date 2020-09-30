package com.jzheng.mapper;

import com.jzheng.pojo.Blog;
import com.jzheng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogMapperTest {
    @Test
    public void test_insert() {
        SqlSession session = MybatisUtils.getSqlSession();
        Blog blog = new Blog();
        blog.setId("1");
        blog.setTitle("t01");
        blog.setAuthor("a01");
        blog.setCreateTime(new Date());
        blog.setViews(1);
        session.getMapper(BlogMapper.class).insertBlog(blog);

        blog.setId("2");
        blog.setTitle("t02");
        blog.setViews(3);
        session.getMapper(BlogMapper.class).insertBlog(blog);

        session.close();
    }

    @Test
    public void test_queryBlogIf() {
        SqlSession session = MybatisUtils.getSqlSession();
        List<Blog> ret;
        Blog blog = new Blog();
        ret = session.getMapper(BlogMapper.class).queryBlogIf(blog);
        printRet(ret);

        System.out.println("------> search by author");
        blog.setAuthor("a01");
        ret = session.getMapper(BlogMapper.class).queryBlogIf(blog);
        printRet(ret);

        System.out.println("------> search by title and author");
        blog.setTitle("t01");
        ret = session.getMapper(BlogMapper.class).queryBlogIf(blog);
        printRet(ret);

        session.close();
    }

    @Test
    public void test_queryBlogWhen() {
        SqlSession session = MybatisUtils.getSqlSession();
        List<Blog> ret;
        Blog blog = new Blog();
        ret = session.getMapper(BlogMapper.class).queryBlogWhen(blog);
        printRet(ret);

        System.out.println("------> search by author");
        blog.setAuthor("a01");
        ret = session.getMapper(BlogMapper.class).queryBlogWhen(blog);
        printRet(ret);

        System.out.println("------> search by title");
        blog.setTitle("t01");
        ret = session.getMapper(BlogMapper.class).queryBlogWhen(blog);
        printRet(ret);

        session.close();
    }

    @Test
    public void test_queryBlogWhere() {
        SqlSession session = MybatisUtils.getSqlSession();
        List<Blog> ret;
        Blog blog = new Blog();
        ret = session.getMapper(BlogMapper.class).queryBlogWhere(blog);
        printRet(ret);

        System.out.println("------> search by author");
        blog.setAuthor("a01");
        ret = session.getMapper(BlogMapper.class).queryBlogWhere(blog);
        printRet(ret);

        System.out.println("------> search by title");
        blog.setTitle("t01");
        ret = session.getMapper(BlogMapper.class).queryBlogWhere(blog);
        printRet(ret);

        session.close();
    }

    @Test
    public void test_updateBlog() {
        SqlSession session = MybatisUtils.getSqlSession();
        Blog blog = new Blog();
        blog.setId("1");
        blog.setTitle("tchange");
        session.getMapper(BlogMapper.class).updateBlog(blog);

        blog.setTitle("tchange02");
        blog.setAuthor("achange02");
        session.getMapper(BlogMapper.class).updateBlog(blog);
        session.close();
    }

    @Test
    public void test_queryBlogIn() {
        SqlSession session = MybatisUtils.getSqlSession();
        Map<String, Object> map = new HashMap<>();
        map.put("ids", Arrays.asList("1", "2", "3"));
        List<Blog> ret = session.getMapper(BlogMapper.class).queryBlogIn(map);
        printRet(ret);
        session.close();
    }

    @Test
    public void test_queryBlogIfScript() {
        SqlSession session = MybatisUtils.getSqlSession();
        Map<String, Object> map = new HashMap<>();
        map.put("title", "t02");
        map.put("author", "a01");
        List<Blog> ret = session.getMapper(BlogMapper.class).queryBlogIfScript(map);
        printRet(ret);
        session.close();
    }

    private void printRet(List<Blog> blogs) {
        System.out.println("Blog size: " + blogs.size());
        for (Blog blog : blogs) {
            System.out.println("Blog: " + blog);
        }
    }
}