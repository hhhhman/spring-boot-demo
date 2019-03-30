package com.demo.bean;


import java.io.Serializable;

public class Users implements Serializable {

    private static final long serialVersionUID = 2L;

    private Integer n_id;
    private String n_name;
    private String n_role;
    private String n_state;
    private String n_pwd;

    public String getN_pwd() {
        return n_pwd;
    }

    public void setN_pwd(String n_pwd) {
        this.n_pwd = n_pwd;
    }

    public Integer getN_id() {
        return n_id;
    }

    public void setN_id(Integer n_id) {
        this.n_id = n_id;
    }

    public String getN_name() {
        return n_name;
    }

    public void setN_name(String n_name) {
        this.n_name = n_name;
    }

    public String getN_role() {
        return n_role;
    }

    public void setN_role(String n_role) {
        this.n_role = n_role;
    }

    public String getN_state() {
        return n_state;
    }

    public void setN_state(String n_state) {
        this.n_state = n_state;
    }
}
