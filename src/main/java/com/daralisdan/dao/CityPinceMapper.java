package com.daralisdan.dao;

import com.daralisdan.entity.City;
import com.daralisdan.entity.CityPince;
import com.daralisdan.entity.CityPinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityPinceMapper {
    long countByExample(CityPinceExample example);

    int deleteByExample(CityPinceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CityPince record);

    int insertSelective(CityPince record);

    List<CityPince> selectByExample(CityPinceExample example);

    CityPince selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CityPince record, @Param("example") CityPinceExample example);

    int updateByExample(@Param("record") CityPince record, @Param("example") CityPinceExample example);

    int updateByPrimaryKeySelective(CityPince record);

    int updateByPrimaryKey(CityPince record);


    List<CityPince> selectCity(Integer id);

}