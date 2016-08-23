package com.aituling.testuipickerview;


import com.aituling.uipickview.data.UIPickViewData;

/**
 * Created by Sai on 15/11/22.
 */
public class ProvinceCityBean implements UIPickViewData {
    private long id;
    private String name;

    public ProvinceCityBean(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProvinceCityBean() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String getPickViewText() {
        return getName();
    }
}
