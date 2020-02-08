package com.daralisdan.controller;

import com.daralisdan.entity.City;
import com.daralisdan.entity.CityPince;
import com.daralisdan.entity.Privince;
import com.daralisdan.service.PrivinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据库---------privince，city
 * @author create by yaodan
 * 2020/2/5-14:48
 */
@Controller
@RequestMapping("/privince")
public class PrivinceController {

    @Autowired
    private PrivinceService privinceService;

    /**
     * 获取所有省份
     *
     * @return
     */
    @PostMapping("/getPrivince")
    @ResponseBody
    public List<Privince> getPrivince() {
        List<Privince> list = privinceService.getPrivince();
        return list;
    }

    /**
     * 根据省份id获取城市信息
     *
     * @return
     */
    @PostMapping("/getCity")
    @ResponseBody
    public List<CityPince> getCity(Integer id) {
        List<CityPince> list = privinceService.getCity(id);
        return list;
    }

}
