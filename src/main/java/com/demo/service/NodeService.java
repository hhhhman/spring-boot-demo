package com.demo.service;

import java.util.List;

import com.demo.bean.Node;

/**
 * @ClassName NodeService
 * @Description service层接口
 * @Author hyj
 * @Date 2019/4/8 10:40
 * @Version 1.0
 */
public interface NodeService {

    /**
     * 查询所有的根节点
     * @return 查询到的根节点的列表
     */
    List<Node> findNodeAll();

    /**
     * 通过名称模糊查询根节点
     * @param name 名称
     * @return 查询到根节点的列表
     */
    List<Node> selectByName(String name);

    /**
     * 增加节点
     * @param node_name 节点名称
     * @param node_desc 节点描述
     * @return 插入的结果
     */
    int addNode(String node_name, String node_desc);

    /**
     * 通过节点的id查询该节点以及它下两层节点
     * @param node_id 节点的id
     * @return 查询到的三层节点
     */
    List<Node> selectChildNodesById(Integer node_id);

    /**
     * 查询节点的下两层节点
     * @param node_id 节点的id
     * @return 查询到的两层子节点
     */
    List<Node> selectChildNodesById1(Integer node_id);

    /**
     * 通过名字模糊查询所在根节点下名称和描述相似的节点
     * @param node_name 查询的名称
     * @param node_id 所在根节点的id
     * @return 查询到的节点的列表
     */
    List<Node> findNodesByName(String node_name, Integer node_id);

    /**
     * 插入子节点
     * @param node_id 节点的id
     * @param node_name 节点的名称
     * @param node_desc 节点的描述
     * @return 返回插入的结果
     */
    Integer insertChildNode(Integer node_id, String node_name, String node_desc);

    /**
     * 修改节点
     * @param node_name 节点的名称
     * @param node_desc 节点的描述
     * @param node_id 节点的id
     */
    void updateNodeById(String node_name, String node_desc, Integer node_id);

    /**
     * 删除节点
     * @param node_id 要删除的节点的id
     */
    void deleteNodeById(Integer node_id);
}
