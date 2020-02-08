package com.daralisdan.service.impl;

import com.daralisdan.dao.TreeResoureMapper;
import com.daralisdan.dto.TreeResourceDto;
import com.daralisdan.entity.TreeResoure;
import com.daralisdan.service.ITreeResoureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author create by yaodan
 * 2020/2/6-10:35
 */

@Service
public class TreeResoureImpl implements ITreeResoureService {
    @Autowired
    private TreeResoureMapper treeResoureMapper;

    /**
     * 根据父id获取子节点们
     * getChildrenByParentId（）： 该方法是通过父节点查询子节点数据
     *
     * @param id
     * @return
     */
    @Override
    public List<TreeResourceDto> getChildrenByParentId(Integer id) {
        //  1.先根据id查询数据
        List<TreeResoure> list;
        if ("".equals(id) || id == null) {
            //  id为空时，查询默认的那个父节点数据
            list = treeResoureMapper.selectParent();
        } else {
            //  id不为空时  获取当前展开的节点的id,通过获取到的节点id查询数据（即查询该id节点下的子节点数据）
            list = treeResoureMapper.getChildrenByParentId(id);
        }
        // 2.新建新的集合，把实体类中的数据封装到与前台接收数据相对应的实体类中
        List<TreeResourceDto> dtoList = new ArrayList<>();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            TreeResoure resource = (TreeResoure) iterator.next();

////        3.循环遍历 查询到的数据 并封装到dto实体类中
            TreeResourceDto dtotree = new TreeResourceDto();
            dtotree.setId(resource.getId());
            dtotree.setText(resource.getName());
            dtotree.setChecked(resource.getChechked());
            dtotree.setIcons(resource.getIcon());
            dtotree.setParentId(resource.getParentId());

            //如果这个集合不为空表示有子节点，此时状态应该关闭状态
            if (getChildren(resource.getId()).size() > 0) {
                dtotree.setState("closed");
            } else {
                dtotree.setState("open");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("url", resource.getUrl());
            dtotree.setAttributes(map);
            dtoList.add(dtotree);
        }

        return dtoList;
    }

    /**
     * 根据pid 获取孩子
     *
     * @param pid
     * @return
     */
    private List<TreeResoure> getChildren(Integer pid) {
        List<TreeResoure> childrenlist = treeResoureMapper.getChildrenByParentId(pid);
        return childrenlist;
    }

    /**
     * 改变节点层次结构的方法
     *
     * @param targetId
     * @param sourceId
     * @param point
     */
    @Override
    public void findById(Integer targetId, Integer sourceId, String point) {
        // 得到目标对象
        TreeResoure target = treeResoureMapper.selectByPrimaryKey(targetId);
        //        得到源对象（操作的对象）
        TreeResoure source = treeResoureMapper.selectByPrimaryKey(sourceId);
        //        point:append,top,bottom
        if ("append".equals(point)) {
            //如果是append，目标对象的父节点id也就是源对象父节点的id
            source.setParentId(target.getId());
        } else if ("top".equals(point)) {
            source.setParentId(target.getParentId());
        }
        treeResoureMapper.updateByPrimaryKey(source);
    }

    @Override
    public void save(TreeResoure treeResoure) {
        treeResoureMapper.insertSelective(treeResoure);
    }

    @Override
    public void update(TreeResoure treeResoure) {
        treeResoureMapper.updateByPrimaryKeySelective(treeResoure);
    }

    /**
     * 两种删除操作都可以
     * 方式一：
     * 递归删除子节点们
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
//        先根据id查询子节点
        List<TreeResoure> children = getChildren(id);
        for (Iterator iterator = children.iterator(); iterator.hasNext(); ) {
            TreeResoure resource = (TreeResoure) iterator.next();
            Integer id1 = resource.getId();
//            如果有子节点，先删除子节点
            treeResoureMapper.deleteByPrimaryKey(id1);
            delete(id1); //在查询子节点下是否还有子节点
        }
//        然后删除父节点
        treeResoureMapper.deleteByPrimaryKey(id);
    }

    /**
     * 方式二：
     * 递归删除子节点们
     *
     * @param id
     */
   /* @Override
    public void delete(Integer id) {
//        先根据id查询子节点 获取要删除的节点下面的所有孩子
        List<TreeResoure> children = getChildren(id);
        for (int i = 0; i < children.size(); i++) {
            Integer id1 = children.get(i).getId();
            treeResoureMapper.deleteByPrimaryKey(id1); //删除子节点
            delete(id1);
        }
//        然后删除父节点
        treeResoureMapper.deleteByPrimaryKey(id);
    }*/
}
