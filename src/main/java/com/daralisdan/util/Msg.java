package com.daralisdan.util;

import lombok.Data;

/**
 * @author create by yaodan
 * 2020/2/3-12:54
 */
@Data
public class Msg {
    private String sta;
    private String mesage;

    public Msg() {
    }

    public Msg(String sta, String mesage) {
        this.sta = sta;
        this.mesage = mesage;
    }
}
