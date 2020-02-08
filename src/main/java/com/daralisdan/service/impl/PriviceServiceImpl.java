package com.daralisdan.service.impl;

import com.daralisdan.dao.CityPinceMapper;
import com.daralisdan.dao.PrivinceMapper;
import com.daralisdan.entity.City;
import com.daralisdan.entity.CityPince;
import com.daralisdan.entity.Privince;
import com.daralisdan.service.PrivinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author create by yaodan
 * 2020/2/5-14:49
 */
@Service
public class PriviceServiceImpl implements PrivinceService {
    @Autowired
    private PrivinceMapper privinceMapper;
    @Autowired
    private CityPinceMapper cityPinceMapper;

    @Override
    public List<Privince> getPrivince() {
        return privinceMapper.selectPrivince();
    }

    @Override
    public List<CityPince> getCity(Integer id) {
        return cityPinceMapper.selectCity(id);
    }


}
