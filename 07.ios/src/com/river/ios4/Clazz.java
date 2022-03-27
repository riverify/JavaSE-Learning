package com.river.ios4;

import java.io.Serializable;

public class Clazz implements Serializable {
    private int cno;
    private String cname;

    public Clazz(int cno, String cname) {
        this.cno = cno;
        this.cname = cname;
    }

    public Clazz() {
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cno=" + cno +
                ", cname='" + cname + '\'' +
                '}';
    }
}
