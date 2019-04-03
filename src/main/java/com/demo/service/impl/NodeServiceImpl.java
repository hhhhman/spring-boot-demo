package com.demo.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.Node;
import com.demo.mapper.NodeMapper;
import com.demo.service.NodeService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


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
        int ret = this.nodeMapper.addNode(node_name, node_desc, count + 1);
        return ret;
    }


    //	点击一次 查询一次子结点
    public List<Node> selectChildNodesById(Integer node_id) {
        return nodeMapper.selectChildNodesById(node_id);
    }

    @Override
    public List<Node> selectChildNodesById1(Integer node_id) {
        return nodeMapper.selectChildNodesById1(node_id);
    }

    /*
     * levelList: 存放所有通过node_name查询到的数据的node_level levelSet: 存放所查到的若干子结点到根结点的路径
     * resultList: 存放最终结果集
     */

    public List<Node> findNodesByName(String node_name, Integer node_id) {
        String node_level = nodeMapper.selectLevelById(node_id);
        List<String> levelList = nodeMapper.selectLevelsByName(node_name, node_level);
        levelList.addAll(nodeMapper.selectChildLevelsByName(node_name, node_level));
        Set<String> levelSet = new HashSet<>();
        List<Node> resultList = new ArrayList<>();
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
    public Integer insertChildNode(Integer node_id, String node_name, String node_desc) {
        List<String> levelList = nodeMapper.selectChildLevelsById(node_id);
        System.out.println(levelList);
        int end;
        if (levelList.isEmpty()) {
            end = 1;
        } else {
            List<Integer> endList = new ArrayList<>();
            for (int i = 0; i < levelList.size(); i++) {
                String str = levelList.get(i);
                endList.add(Integer.parseInt(str.substring(str.lastIndexOf(".") + 1)));
            }
            Collections.sort(endList);
            end = endList.get(endList.size() - 1) + 1;
        }
        String level = nodeMapper.selectLevelById(node_id);
        String node_level = level + "." + end;
        Integer node_pid = node_id;
        nodeMapper.insertChildNode(node_level, node_name, node_desc, node_pid);
        List<Integer> list = nodeMapper.selectIdByName(node_name);
        if (list.size() > 1) {
            for (Integer id : list) {
                nodeMapper.deleteNodeById(id);
            }
            return -1;
        } else {
            return list.get(0);
        }
    }

    public void updateNodeById(String node_name, String node_desc, Integer node_id) {
        nodeMapper.updateNodeById(node_name, node_desc, node_id);
    }

    public void deleteNodeById(Integer node_id) {
        String node_level = nodeMapper.selectLevelById(node_id);
        if (node_level.matches("/^[0-9]+.*/")) {
            nodeMapper.deleteNodeById(node_id);
        } else {
            nodeMapper.updateStateById(node_id);
        }

    }


}
