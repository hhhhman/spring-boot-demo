package com.demo.service;

import java.util.List;

import com.demo.bean.Node;

public interface NodeService {

    List<Node> findNodeAll();

    List<Node> selectByName(String name);

    int addNode(String node_name, String node_desc);

    List<Node> selectChildNodesById(Integer node_id);

    List<Node> selectChildNodesById1(Integer node_id);

    List<Node> findNodesByName(String node_name, Integer node_id);

    Integer insertChildNode(Integer node_id, String node_name, String node_desc);

    void updateNodeById(String node_name, String node_desc, Integer node_id);

    void deleteNodeById(Integer node_id);
}
