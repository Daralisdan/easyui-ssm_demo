package com.daralisdan.service;


import com.daralisdan.dto.TreeResourceDto;
import com.daralisdan.entity.TreeResoure;

import java.util.List;


/**
 * @author create by yaodan
 * 2020/2/6-10:35
 */
public interface ITreeResoureService {
    List<TreeResourceDto> getChildrenByParentId(Integer id);

    void findById(Integer targetId, Integer sourceId, String point);

    void save(TreeResoure treeResoure);

    void update(TreeResoure treeResoure);

    void delete(Integer id);
}
