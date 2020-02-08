package com.daralisdan.util;

import lombok.Data;

import java.util.List;

/**
 * @author create by yaodan
 * 2020/2/4-10:28
 */
@Data
public class Json {
    private String total;
    private List<Object> rows;

    public Json() {
    }

    public Json(String total, List<Object> rows) {
        this.total = total;
        this.rows = rows;
    }
}
