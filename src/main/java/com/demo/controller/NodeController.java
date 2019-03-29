package com.demo.controller;

import java.util.List;

import com.demo.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.*;

import com.demo.bean.Node;
import com.demo.service.NodeService;
import com.demo.util.toTree;

@RestController
@RequestMapping("/node")
public class NodeController {
    @Autowired
    private NodeService nodeService;

    /**
     * 查询主页面二级根节点
     */
    @GetMapping("/knowledgeTree")
    public List<Node> findNodeAll() {
        List<Node> list = this.nodeService.findNodeAll();
        List<Node> result = toTree.listToTree(list);
        return result;
    }

    /**
     * 通过名称查询
     * @param name 节点的名称
     * @return
     */
    @GetMapping("/knowledgeTree/{name}")
    public List<Node> selectByName(@PathVariable String name) {
        List<Node> list = this.nodeService.selectByName(name);
        return list;
    }

    /**
     * 主界面增加节点
     * @param node_name 节点姓名
     * @param node_desc 节点描述
     * @return
     */
    @PostMapping("/addNode")
    public String addNode(String node_name, String node_desc) {
        int ret = this.nodeService.addNode(node_name, node_desc);
        if (ret == 1) {
            return "success";
        }
        return "error";
    }

    /**
     * 子界面通过id查询节点所有子节点
     * @param node_id
     * @return
     */
    @GetMapping("/selectChilds/{node_id}")
    public List<Node> selectChildNodesById(@PathVariable("node_id") Integer node_id) {
        return nodeService.selectChildNodesById(node_id);
    }

    /**
     * 通过名字模糊查询节点
     * @param node_name 节点名称
     * @param node_level 节点层级
     * @return
     */
    @GetMapping(value = "/findNodes/{node_name}/{node_level}")
    public List<Node> findNodesByName(@PathVariable("node_name") String node_name,
                                      @PathVariable("node_level") String node_level) {
        return nodeService.findNodesByName(node_name, node_level);
    }

    /**
     * 增加节点
     * @param node_id 节点编号
     * @param node_name 节点名称
     * @param node_desc 节点描述
     * @return
     */
    @PostMapping(value = "/insertNode/{node_id}/{node_name}/{node_desc}")
    public String insertChildNode(@PathVariable("node_id") Integer node_id,
                                  @PathVariable("node_name") String node_name,
                                  @PathVariable("node_desc") String node_desc) {
        try {
            nodeService.insertChildNode(node_id, node_name, node_desc);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }


    @PutMapping("/updateNode/{node_id}/{node_name}/{node_desc}")
    public String updateNodeById(@PathVariable("node_name") String node_name,
                                 @PathVariable("node_desc") String node_desc,
                                 @PathVariable("node_id") Integer node_id) {
        try {
            nodeService.updateNodeById(node_name, node_desc, node_id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @DeleteMapping("/deleteNode/{node_id}")
    public String deleteNodeById(@PathVariable("node_id") Integer node_id) {
        try {
            nodeService.deleteNodeById(node_id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

}
