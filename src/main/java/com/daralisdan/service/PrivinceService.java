package com.daralisdan.service;

import com.daralisdan.entity.City;
import com.daralisdan.entity.CityPince;
import com.daralisdan.entity.Privince;

import java.util.List;

/**
 * @author create by yaodan
 * 2020/2/5-14:49
 */
public interface PrivinceService {
    List<Privince> getPrivince();

    List<CityPince> getCity(Integer id);

}
