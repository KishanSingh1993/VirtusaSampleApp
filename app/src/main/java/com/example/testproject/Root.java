package com.example.testproject;

public class Root {

    public Data data;
    public Support support;

    public Root(Data data, Support support) {
        this.data = data;
        this.support = support;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
