package com.daralisdan.controller;

import com.daralisdan.entity.City;
import com.daralisdan.entity.User;
import com.daralisdan.service.IUserService;
import com.daralisdan.util.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库-----user
 * @author create by yaodan
 * 2020/2/3-10:41
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 获取城市的数据
     *
     * @return
     */
    @PostMapping("/getCity")
    @ResponseBody
    public List getCity() {
        List<City> clist = new ArrayList<>();
        clist.add(new City(1, "北京"));
        clist.add(new City(2, "上海"));
        clist.add(new City(3, "深圳"));
        clist.add(new City(4, "四川"));
        System.out.println(clist);
        return clist;
    }

    /**
     * getCityName
     */
    @PostMapping("/getCityName")
    @ResponseBody
    public Object getCityName(Integer id) {
        List<City> clist = new ArrayList<>();
        clist.add(new City(1, "北京"));
        clist.add(new City(2, "上海"));
        clist.add(new City(3, "深圳"));
        clist.add(new City(4, "四川"));
        System.out.println(clist);
        //循环遍历集合
        City c = null;
        for (City city : clist) {
            if (city.getId() == id) {
                c = city;
            }
        }
        return c;
    }

    /**
     * 保存用户数据
     *
     * @param user
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Msg save(User user) {
        Msg msg;
        iUserService.save(user);
        msg = new Msg("ok", "操作成功");
        return msg;
    }

    /**
     * 查询所有
     * {"total":1,
     * "rows":[{"id":27,
     * "username":"admin",
     * "password":"1234"  }]
     * }  datagrid是这种json数据格式，需要用map去封装-->
     *
     * @return
     */

    @RequestMapping("/getList")
    @ResponseBody
    public Map<String, Object> getList() {
        Map<String, Object> map = new HashMap<>();

        List<User> list = iUserService.getList();
        map.put("total", list.size());
        map.put("rows", list);
        System.out.println(map);
        return map;
    }


    /**
     * 分页显示
     * page 当前页
     * rows 当前页的条数
     * [使用分页插件的分页查询]
     *
     * @return
     */
    @RequestMapping("/getListPageHelper")
    @ResponseBody
    public Map<String, Object> getListPageHelper(Integer page, Integer rows) {
        //new一个map对象封装数据，最后需要把这个map传递到前台页面中去
        Map<String, Object> map = new HashMap<>();

        // 1.引入分页插件，在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(page, rows);
        // 2. startPage后面紧跟的这个查询就是一个分页查询。将查询出来的集合放进list对象里面
        List<User> list = iUserService.getList();
        System.out.println(list);
        // 3.使用pageinfo对结果进行包装，只需要将pageinfo交给页面
        PageInfo<User> pageInfo = new PageInfo<>(list);

        //total是总条数，通过info.get的方法将总条数放进total对象里面
        map.put("total", pageInfo.getTotal());
        //将查询出来的list数据放进rows里面
        map.put("rows", pageInfo.getList());
        //最终将map对象给返回到前台页面
        System.out.println(pageInfo + "=======================");
        return map;
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Msg update(User user) {
        Msg msg;
        iUserService.update(user);
        msg = new Msg("ok", "修改成功");
        return msg;
    }

    /**
     * 删除用户，【可以批量删除】
     *
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public Msg delete(String ids) {
        Msg msg;
        iUserService.delete(ids);
        System.out.println(ids);
        System.out.println("===================");
        msg = new Msg("ok", "删除成功");
        return msg;
    }

    /**
     * 条件+分页显示
     * page 当前页
     * rows 当前页的条数
     * [使用分页插件的分页查询]
     *
     * @return
     */
    @RequestMapping("/selectCondition")
    @ResponseBody
    public Map<String, Object> selectCondition(Integer page, Integer rows, User user) {
        //new一个map对象封装数据，最后需要把这个map传递到前台页面中去
        Map<String, Object> map = new HashMap<>();

        // 1.引入分页插件，在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(page, rows);
        // 2. startPage后面紧跟的这个查询就是一个分页查询。将查询出来的集合放进list对象里面
        List<User> list = iUserService.selectCondition(user);
        System.out.println(list);
        // 3.使用pageinfo对结果进行包装，只需要将pageinfo交给页面
        PageInfo<User> pageInfo = new PageInfo<>(list);

        //total是总条数，通过info.get的方法将总条数放进total对象里面
        map.put("total", pageInfo.getTotal());
        //将查询出来的list数据放进rows里面
        map.put("rows", pageInfo.getList());
        //最终将map对象给返回到前台页面
        System.out.println(pageInfo + "=======================");
        return map;
    }

    //    getListName
    @RequestMapping("/getListName")
    @ResponseBody
    public List<User> getListName(String username) {
        List<User> list = iUserService.getListName(username);
        return list;
    }
}
