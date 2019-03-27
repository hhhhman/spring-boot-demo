package com.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.demo.bean.Node;

public class toTree {

	public static List<Node> listToTree(List<Node> list){
		List<Node > nodeList = new ArrayList<>();    
	    for(Node node1 : list){//taskDTOList 是数据库获取的List列表数据或者来自其他数据源的List
	                boolean mark = false;
	                for(Node node2 : list){
	                    if(node1.getNode_pid()!=null && node1.getNode_pid().equals(node2.getNode_id())){
	                        mark = true;
	                        if(node2.getChildren() == null)
	                            node2.setChildren(new ArrayList<Node>());
	                        node2.getChildren().add(node1);
	                        break;
	                    }
	                }
	                if(!mark){
	                    nodeList.add(node1);
	                }
	            }
		return nodeList;
	}
}
