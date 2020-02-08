package com.daralisdan.dao;

import com.daralisdan.entity.TreeResoure;
import com.daralisdan.entity.TreeResoureExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TreeResoureMapper {
    long countByExample(TreeResoureExample example);

    int deleteByExample(TreeResoureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TreeResoure record);

    int insertSelective(TreeResoure record);

    List<TreeResoure> selectByExample(TreeResoureExample example);

    TreeResoure selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TreeResoure record, @Param("example") TreeResoureExample example);

    int updateByExample(@Param("record") TreeResoure record, @Param("example") TreeResoureExample example);

    int updateByPrimaryKeySelective(TreeResoure record);

    int updateByPrimaryKey(TreeResoure record);

    /**
     * 查询父节点数据
     *
     * @return
     */
    List<TreeResoure> selectParent();

    /**
     * 根据父节点查询子节点数据
     *
     * @param id
     * @return
     */
    List<TreeResoure> getChildrenByParentId(Integer id);

    List<TreeResoure> selectList(TreeResoure treeResoure);

}