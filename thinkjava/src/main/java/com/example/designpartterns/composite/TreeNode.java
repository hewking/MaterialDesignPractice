package com.example.designpartterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hewking on 2016/11/2.
 * 组合模式 将多个对象组合在一起使用，通常用于属性结构中，入二叉树
 */

public class TreeNode {

    String name;
    TreeNode parent;
    List<TreeNode> childrens = new ArrayList<>();

    public void setName(String s){
        this.name = s;
    }

    public void setParent(TreeNode node){
        this.parent = node;
    }

    public void add(TreeNode child){
        childrens.add(child);
    }

    public void remove(TreeNode child){
        childrens.remove(child);
    }
}
