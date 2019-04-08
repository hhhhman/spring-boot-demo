package com.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.demo.bean.Node;

/**
 * @ClassName ToTree
 * @Description 节点转树的工具类，使用了双层循环遍历的方法
 * @Author hyj
 * @Date 2019/4/8 10:40
 * @Version 1.0
 */
public class ToTree {

    public static List<Node> listToTree(List<Node> list) {
        List<Node> nodeList = new ArrayList<>();
        for (Node node1 : list) {
            boolean mark = false;
            for (Node node2 : list) {
                if (node1.getNode_pid() != null && node1.getNode_pid().equals(node2.getNode_id())) {
                    mark = true;
                    if (node2.getChildren() == null) {
                        node2.setChildren(new ArrayList<Node>());
                    }
                    node2.getChildren().add(node1);
                    break;
                }
            }
            if (!mark) {
                nodeList.add(node1);
            }
        }
        return nodeList;
    }
}
