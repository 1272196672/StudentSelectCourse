package com.entity;

/**
 * @author 林子翔
 * @since 2022 05 2022/5/13
 */
public class User {
    private String name,account,pwd;
    private int id;

    public User(String name, String account, String pwd, int id) {
        this.name = name;
        this.account = account;
        this.pwd = pwd;
        this.id = id;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                ", id=" + id +
                '}';
    }
}
