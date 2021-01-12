package com.wisdom.vo;

import java.io.Serializable;
import java.util.List;

public class InstitutionsTree implements Serializable {

    private String code;
    private String codeName;
    private String parent;
    private Integer level;
    private String describe;
    private List<InstitutionsTree> children;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public List<InstitutionsTree> getChildren() {
        return children;
    }

    public void setChildren(List<InstitutionsTree> children) {
        this.children = children;
    }
}
