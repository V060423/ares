package com.study.cloud.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author wangbowen
 * @Description 用户实体对象
 * @Date 2018/4/18 10:51
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    private Long id;
    private String userName;
    private String name;
    private Integer age;
    private BigDecimal balance;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
