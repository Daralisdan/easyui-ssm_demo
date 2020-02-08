package com.daralisdan.service.impl;

import com.daralisdan.dao.UserMapper;
import com.daralisdan.entity.User;
import com.daralisdan.entity.UserExample;
import com.daralisdan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author create by yaodan
 * 2020/2/3-10:42
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 保存
     *
     * @param user
     * @return
     */
    @Override
    public int save(User user) {
        int i = userMapper.insert(user);
        System.out.println(i + "dao====================");
        return i;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<User> getList() {
        List<User> list = userMapper.selectList();
        return list;
    }

    /**
     * 修改
     *
     * @param user
     */
    @Override
    public void update(User user) {
        Integer id = user.getId();
        if (id > 0) {
            User users = userMapper.selectByPrimaryKey(id);
            if (!ObjectUtils.isEmpty(users)) {
                userMapper.updateByPrimaryKey(user);
            }
        }
    }

    /**
     * 删除
     *
     * @param ids
     */
    @Override
    public void delete(String ids) {
        String[] idss = ids.split(",");
        for (String s : idss) {
            Integer id = Integer.parseInt(s);
            System.out.println("dao=================ids");
            System.out.println(id);
            userMapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * 条件+分页
     *
     * @param user
     * @return
     */
    @Override
    public List<User> selectCondition(User user) {
        List<User> list = userMapper.selectCondition(user);
        System.out.println("dao分页============================");
        System.out.println(list);
        System.out.println("============================");
        return list;
    }

    @Override
    public List<User> getListName(String username) {
        return userMapper.selectListName(username);
    }


}
