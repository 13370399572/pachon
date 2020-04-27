package com.feng.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Created by rf on 2019/4/3.
 */
@Data
@Table(name = "tb_blog")
@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 32)
    private Integer id;
    /*@NotBlank(message = "博客标题不能为空")*/
    @Column
    private String title;
    @Column(length = 255)
    private String author;
    @Column(length = 255)
    private String publishTime;
    @Column(length = 255)
   /* @NotBlank(message = "博客url地址不能为空")*/
    private String sourceUrl;
    private String readNum;

    public Blog(String title, String author, String publishTime, String sourceUrl, String readNum) {
        this.title = title;
        this.author = author;
        this.publishTime = publishTime;
        this.sourceUrl = sourceUrl;
        this.readNum = readNum;
    }

    public Blog() {
    }
}