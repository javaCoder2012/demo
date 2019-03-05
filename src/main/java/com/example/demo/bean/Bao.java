package com.example.demo.bean;


import java.util.List;

public class Bao<T> {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
