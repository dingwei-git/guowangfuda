package com.wisdom.vo;

import lombok.Data;

import java.util.List;

@Data
public class NodeTreeVO {
    private Long id;
    private String name;
    private Long parentId;
    private List<NodeTreeVO> childrens;

    public NodeTreeVO() {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.childrens = childrens;
    }
}
