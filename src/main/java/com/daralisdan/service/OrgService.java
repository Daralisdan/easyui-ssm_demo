package com.daralisdan.service;

import com.daralisdan.entity.Org;

import java.util.List;

/**
 * @author create by yaodan
 * 2020/2/7-21:29
 */
public interface OrgService {
    List<Org> getOrgList(Integer id);

    void save(Org org);

    void update(Org org);

    void delete(Integer id);
}
