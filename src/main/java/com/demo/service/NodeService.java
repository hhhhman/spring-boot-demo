package com.demo.service;

import java.util.List;

import com.demo.bean.Node;

public interface NodeService {

    public List<Node> findNodeAll();

    public List<Node> selectByName(String name);

    public int addNode(String node_name, String node_desc);

    public List<Node> selectChildNodesById(Integer node_id);

    public List<Node> findNodesByName(String node_name, String node_level);

    public void insertChildNode(Integer node_id, String node_name, String node_desc);

    public void updateNodeById(String node_name, String node_desc, Integer node_id);

    public void deleteNodeById(Integer node_id);
}
