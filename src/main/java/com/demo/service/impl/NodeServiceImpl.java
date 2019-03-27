package com.demo.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.Node;
import com.demo.mapper.NodeMapper;
import com.demo.service.NodeService;


@Service
@Transactional
public class NodeServiceImpl implements NodeService {

    @Autowired
    private NodeMapper nodeMapper;

    @Override
    public List<Node> findNodeAll() {
        return this.nodeMapper.selectNodeAll();
    }

    @Override
    public List<Node> selectByName(String name) {
        System.out.println("service 层 " + name);
        return this.nodeMapper.selectName(name);
    }

    @Override
    public int addNode(String node_name, String node_desc) {
        String count = this.nodeMapper.countByLevel();
        int ret = this.nodeMapper.addNode(node_name, node_desc, count);
        System.out.println(ret);
        return ret;
    }


    //	点击一次 查询一次子结点
    public List<Node> selectChildNodesById(Integer node_id) {
        return nodeMapper.selectChildNodesById(node_id);
    }

    /*
     * levelList: 存放所有通过node_name查询到的数据的node_level levelSet: 存放所查到的若干子结点到根结点的路径
     * resultList: 存放最终结果集
     */

    public List<Node> findNodesByName(String node_name, String node_level) {
        List<String> levelList = nodeMapper.selectLevelsByName(node_name, node_level);
        levelList.addAll(nodeMapper.selectChildLevelsByName(node_name, node_level));
        Set<String> levelSet = new HashSet<String>();
        List<Node> resultList = new ArrayList<Node>();
        for (int i = 0; i < levelList.size(); i++) {
            String str = levelList.get(i);
            levelSet.add(str);
            while (str.contains(".")) {
                str = str.substring(0, str.lastIndexOf("."));
                levelSet.add(str);
            }
        }
        for (String level : levelSet) {
            resultList.add(nodeMapper.selectNodeByLevel(level));
        }
        return resultList;
    }

    /*
     * List<String> levelList: 存放子结点的node_level List<Integer> endList:
     * 存放node_level的尾部
     */

    public void insertChildNode(Integer node_id, String node_name, String node_desc) {
        List<String> levelList = nodeMapper.selectChildLevelsById(node_id);
        List<Integer> endList = new ArrayList<Integer>();
        for (int i = 0; i < levelList.size(); i++) {
            String str = levelList.get(i);
            endList.add(Integer.parseInt(str.substring(str.lastIndexOf(".") + 1)));
        }
        Collections.sort(endList);
        Integer end = endList.get(endList.size() - 1) + 1;
        String level = nodeMapper.selectLevelById(node_id);
        String node_level = null;
        if (level.contains(".")) {
            node_level = level.substring(0, level.lastIndexOf(".") + 1) + end;
        } else {
            node_level = level + "." + end;
        }
        Integer node_pid = node_id;
        nodeMapper.insertChildNode(node_level, node_name, node_desc, node_pid);
    }

    public void updateNodeById(String node_name, String node_desc, Integer node_id) {
        nodeMapper.updateNodeById(node_name, node_desc, node_id);
    }

    public void deleteNodeById(Integer node_id) {
        nodeMapper.deleteNodeById(node_id);
    }


}
