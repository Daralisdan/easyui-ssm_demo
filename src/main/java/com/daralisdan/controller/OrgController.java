package com.daralisdan.controller;

import com.daralisdan.entity.Org;
import com.daralisdan.entity.Org;
import com.daralisdan.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 数据库-----org
 *
 * @author create by yaodan
 * 2020/2/7-21:28
 */
@Controller
@RequestMapping("/org")
public class OrgController {
    @Autowired
    private OrgService orgService;

    /**
     * 获取组织机构数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/getOrgList")
    @ResponseBody
    public List<Org> getOrgList(Integer id) {
        return orgService.getOrgList(id);
    }


    /**
     * 保存节点的方法
     */
    @PostMapping("/save")
    @ResponseBody
    public void save(Org org) {
        orgService.save(org);
    }

    /**
     * 修改节点的方法
     */
    @PostMapping("/update")
    @ResponseBody
    public void update(Org org) {
        orgService.update(org);
    }

    /**
     * 修改节点的方法
     */
    @PostMapping("/delete")
    @ResponseBody
    public void delete(Integer id) {
        orgService.delete(id);
    }
}
