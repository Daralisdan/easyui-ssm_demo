package com.daralisdan.entity;

import lombok.Data;

/**
 * @author create by yaodan
 * 2020/2/3-10:46
 */
@Data
public class City {
    private int id;
    private String name;

    public City() {
        super();
    }

    public City(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
