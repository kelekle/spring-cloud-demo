package com.kle.producer.model;

import lombok.Data;

import java.util.Date;

/**
 * 学生实体类
 * @author ypb
 */
@Data
public class Student {

    private int sid;

    private String name;

    private String password;

    private Date createTime;

    private Date updateTime;

}
