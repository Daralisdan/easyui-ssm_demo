package com.daralisdan.entity;

import lombok.Data;

@Data
public class Org {
    private Integer id;

    private String name;

    private String iconcls;

    private String principal; //负责人

    private Integer count; //总人数

    private String descript; //描述

    private String state; //状态

    private Integer parentId; //父id

    public Org() {
    }

    public Org(Integer id, String name, String iconcls, String principal, Integer count, String descript, String state, Integer parentId) {
        this.id = id;
        this.name = name;
        this.iconcls = iconcls;
        this.principal = principal;
        this.count = count;
        this.descript = descript;
        this.state = state;
        this.parentId = parentId;
    }
}