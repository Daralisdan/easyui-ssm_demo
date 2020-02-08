package com.daralisdan.dao;

import com.daralisdan.entity.Privince;
import com.daralisdan.entity.PrivinceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PrivinceMapper {
    long countByExample(PrivinceExample example);

    int deleteByExample(PrivinceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Privince record);

    int insertSelective(Privince record);

    List<Privince> selectByExample(PrivinceExample example);

    Privince selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Privince record, @Param("example") PrivinceExample example);

    int updateByExample(@Param("record") Privince record, @Param("example") PrivinceExample example);

    int updateByPrimaryKeySelective(Privince record);

    int updateByPrimaryKey(Privince record);

    /**
     * 查询所有
     *
     * @return
     */
    List<Privince> selectPrivince();

}