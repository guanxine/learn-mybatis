package org.mybatis.example.bean;

/**
 * Created by guanxine on 18-12-29.
 */
public class Blog {
    private Integer id;
    private String name;
    private String content;


    public Integer getId() {
        return id;
    }

    public Blog setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Blog setName(String name) {
        this.name = name;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Blog setContent(String content) {
        this.content = content;
        return this;
    }
}
