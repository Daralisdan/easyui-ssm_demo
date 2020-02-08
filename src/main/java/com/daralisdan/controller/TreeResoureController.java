package com.daralisdan.controller;

import com.daralisdan.dto.TreeResourceDto;
import com.daralisdan.entity.TreeResoure;
import com.daralisdan.service.ITreeResoureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 数据库-----treeresoure
 * @author create by yaodan
 * 2020/2/6-10:35
 */

@Controller
@RequestMapping("/tree")
public class TreeResoureController {
    @Autowired
    private ITreeResoureService iTreeResoureService;


    /**
     * 加载树的数据方法
     * <p>
     * tree的特点：
     * 发送异步ajax请求的时候会携带一个id的参数(即点击节点时发送异步请求，就会携带一个id传到后台)
     *
     * @return id:点击节点时发送异步请求，就会携带一个id传到后台(点击节点的id)
     */

    @PostMapping("/getTree")
    @ResponseBody
    public List<TreeResourceDto> getTree(Integer id) {
//        获取当前展开的节点的id
        List<TreeResourceDto> dtoList = iTreeResoureService.getChildrenByParentId(id);
        return dtoList;
    }

    /**
     * 改变节点层次结构的方法
     */
    @PostMapping("/changeLevel")
    @ResponseBody
    public void changeLevel(Integer targetId, Integer sourceId, String point) {
        iTreeResoureService.findById(targetId, sourceId, point);
    }

    /**
     * 保存节点的方法
     */
    @PostMapping("/save")
    @ResponseBody
    public void save(TreeResoure treeResoure) {
        iTreeResoureService.save(treeResoure);
    }

    /**
     * 修改节点的方法
     */
    @PostMapping("/update")
    @ResponseBody
    public void update(TreeResoure treeResoure) {
        iTreeResoureService.update(treeResoure);
    }

    /**
     * 修改节点的方法
     */
    @PostMapping("/delete")
    @ResponseBody
    public void delete(Integer id) {
        iTreeResoureService.delete(id);
    }
}
