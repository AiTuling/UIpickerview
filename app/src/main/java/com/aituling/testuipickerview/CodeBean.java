package com.aituling.testuipickerview;

import java.util.List;

/**
 * Created by Andy on 2016/8/22.
 */
public class CodeBean {


    /**
     * id : 0
     * name : 全部
     * son : [{"name":"全部","id":0}]
     */

    private int id;
    private String name;
    /**
     * name : 全部
     * id : 0
     */

    private List<SonBean> son;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SonBean> getSon() {
        return son;
    }

    public void setSon(List<SonBean> son) {
        this.son = son;
    }

    public static class SonBean {
        private String name;
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
