package com.daralisdan.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author create by yaodan
 * 2020/2/6-10:54
 * <p>
 * 封装tree的数据(即把TreeResoure实体类的数据转换成TreeResourceDto的数据传到前台)
 * 格式要与前台tree接收的格式相对应
 */
/*树的数据格式（Tree Data Format）每个节点可以包括下列属性：
        id：节点的 id，它对于加载远程数据很重要。
        text：要显示的节点文本。
        state：节点状态，'open' 或 'closed'，默认是 'open'。当设置为 'closed' 时，该节点有子节点，并且将从远程站点加载它们。
        checked：指示节点是否被选中。
        attributes：给一个节点添加的自定义属性。
        children：定义了一些子节点的节点数组。
    比如：
   [  {
        "id":1,
        "text":"Folder1",
        "iconCls":"icon-save",
        "children":[{
            "text":"File1",
            "checked":true
        }]-->*/
@Data
public class TreeResourceDto {
    private int id;
    private String text;//要显示的节点文本。
    private String icons;
    private int checked; //指示节点是否被选中。
    private int parentId; //父节点id
    //    封装额外的数据（自定义参数，比如：url）
    private Map<String, Object> attributes = new HashMap<String, Object>();
    private String state; //节点状态

    public TreeResourceDto() {
    }

    public TreeResourceDto(int id, String text, String icons, int checked, int parentId, Map<String, Object> attributes, String state) {
        this.id = id;
        this.text = text;
        this.icons = icons;
        this.checked = checked;
        this.parentId = parentId;
        this.attributes = attributes;
        this.state = state;
    }
}
