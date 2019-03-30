package com.demo.bean;

import java.io.Serializable;
import java.util.List;



public class Node implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer node_id;
	private String node_name;
	private String node_desc;
	private String node_state;



	private Integer node_pid;


	private List<Node> children;

	public Integer getNode_id() {
		return node_id;
	}

	public void setNode_id(Integer node_id) {
		this.node_id = node_id;
	}

	public String getNode_name() {
		return node_name;
	}

	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}

	public String getNode_desc() {
		return node_desc;
	}

	public void setNode_desc(String node_desc) {
		this.node_desc = node_desc;
	}

	public String getNode_state() {
		return node_state;
	}

	public void setNode_state(String node_state) {
		this.node_state = node_state;
	}

	public Integer getNode_pid() {
		return node_pid;
	}

	public void setNode_pid(Integer node_pid) {
		this.node_pid = node_pid;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Node [node_id=" + node_id + ", node_name=" + node_name + ", node_desc=" + node_desc + ", node_state="
				+ node_state + ", node_pid=" + node_pid + ", children=" + children + "]";
	}


}
