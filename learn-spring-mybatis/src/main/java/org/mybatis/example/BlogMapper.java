package org.mybatis.example;

import org.mybatis.example.bean.Blog;

/**
 * Created by guanxine on 18-12-29.
 */
public interface BlogMapper {

    Blog select(int id);
}
