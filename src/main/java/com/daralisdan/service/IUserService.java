package com.daralisdan.service;

import com.daralisdan.entity.User;

import java.util.List;

/**
 * @author create by yaodan
 * 2020/2/3-10:42
 */
public interface IUserService {

    int save(User user);

    List<User> getList();

    void update(User user);

    void delete(String ids);

    List<User> selectCondition(User user);

    List<User> getListName(String username);
}
