package com.daralisdan.service.impl;

import com.daralisdan.dao.OrgMapper;
import com.daralisdan.dto.TreeResourceDto;
import com.daralisdan.entity.Org;
import com.daralisdan.entity.TreeResoure;
import com.daralisdan.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author create by yaodan
 * 2020/2/7-21:29
 */
@Service
public class OrgServiceImpl implements OrgService {
    @Autowired
    private OrgMapper orgMapper;

    @Override
    public List<Org> getOrgList(Integer id) {
        List<Org> list;
        if ("".equals(id) || id == null) {
            //  id为空时，查询默认的那个父节点数据
            list = orgMapper.selectParent();
        } else {
            //  id不为空时  获取当前展开的节点的id,通过获取到的节点id查询数据（即查询该id节点下的子节点数据）
            list = orgMapper.getChildrenByParentId(id);
        }

        List<Org> olist = new ArrayList<>();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Org org = (Org) iterator.next();
            Org o = new Org();
            o.setId(org.getId());
            o.setName(org.getName());
            o.setPrincipal(org.getPrincipal());
            o.setIconcls(org.getIconcls());
            o.setCount(org.getCount());
            o.setDescript(org.getDescript());
            o.setParentId(org.getParentId());
            if (getChildren(org.getId()).size() > 0) {
                org.setState("closed");
            } else {
                org.setState("open");
            }
            olist.add(org);
        }
        return olist;
    }

    @Override
    public void save(Org org) {
        orgMapper.insertSelective(org);
    }

    @Override
    public void update(Org org) {
        orgMapper.updateByPrimaryKeySelective(org);
    }

    @Override
    public void delete(Integer id) {
//        先根据id查询子节点
        List<Org> children = getChildren(id);
        for (Iterator iterator = children.iterator(); iterator.hasNext(); ) {
            Org org = (Org) iterator.next();
            Integer id1 = org.getId();
//            如果有子节点，先删除子节点
            orgMapper.deleteByPrimaryKey(id1);
            delete(id1); //在查询子节点下是否还有子节点
        }
//        然后删除父节点
        orgMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据pid 获取孩子
     *
     * @param pid
     * @return
     */
    private List<Org> getChildren(Integer pid) {
        List<Org> childrenlist = orgMapper.getChildrenByParentId(pid);
        return childrenlist;
    }
}
