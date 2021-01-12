package com.wisdom.utils;


import com.wisdom.vo.InstitutionsTree;
import com.wisdom.vo.NodeTreeVO;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取架构树结构
 */
public class TreeUtils {

    private List<InstitutionsTree> menuList = new ArrayList<InstitutionsTree>();
    public TreeUtils(List<InstitutionsTree> menuList) {
        this.menuList=menuList;
    }

    //建立树形结构
    public List<InstitutionsTree> builTree(){
        List<InstitutionsTree> treeMenus =new  ArrayList<InstitutionsTree>();
        for(InstitutionsTree menuNode : getRootNode()) {
//        for(InstitutionsTree menuNode : menuList) {
            menuNode=buildChilTree(menuNode);
            treeMenus.add(menuNode);
        }
        return treeMenus;
    }

    //递归，建立子树形结构
    private InstitutionsTree buildChilTree(InstitutionsTree pNode){
        List<InstitutionsTree> chilMenus =new  ArrayList<InstitutionsTree>();
        for(InstitutionsTree menuNode : menuList) {
            if(menuNode.getParent().equals(pNode.getCode())) {
                chilMenus.add(buildChilTree(menuNode));
            }
        }
        pNode.setChildren(chilMenus);
        return pNode;
    }

    //获取根节点
    private List<InstitutionsTree> getRootNode() {
        List<InstitutionsTree> rootMenuLists =new  ArrayList<InstitutionsTree>();
        for(InstitutionsTree menuNode : menuList) {
            if(menuNode.getParent().equals("000000")) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }






    public static List<NodeTreeVO>  getTree(List<NodeTreeVO> nodeTreeVOList ){
        List<NodeTreeVO> nodeList = new ArrayList<NodeTreeVO>();
        for (NodeTreeVO node : nodeTreeVOList) {
            Long id = node.getId();
            if (node.getParentId() == -1) {
                node = buildTree(nodeTreeVOList,node);
                nodeList.add(node);
            }
        }
        return nodeList;
    }


    public static NodeTreeVO buildTree(List<NodeTreeVO> list,NodeTreeVO node){
        List<NodeTreeVO> children = new ArrayList<NodeTreeVO>();
        for(NodeTreeVO item:list){
            if(item.getParentId()==node.getId()){
                children.add(buildTree(list,item));
            }
        }
        node.setChildrens(children);
        return node;
    }

}
