package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
     * 查询一个根下所有节点
     */
    @GetMapping("/knowledgeTree")
    public List<Node> findNodeAll() {
        List<Node> list = this.nodeService.findNodeAll();
        List<Node> result = toTree.listToTree(list);
        return result;
    }


    @GetMapping("/knowledgeTree/{name}")
    public List<Node> selectByName(@PathVariable String name) {
        List<Node> list = this.nodeService.selectByName(name);
        return list;
    }

    @PostMapping("/addNode")
    public String addNode(String node_name, String node_desc) {
        int ret = this.nodeService.addNode(node_name, node_desc);
        if (ret == 1) {
            return "success";
        }
        return "error";
    }


    @GetMapping("/selectChilds/{node_id}")
    public List<Node> selectChildNodesById(@PathVariable("node_id") Integer node_id) {
        return nodeService.selectChildNodesById(node_id);
    }

    @GetMapping(value = "/findNodes/{node_name}/{node_level}")
    public List<Node> findNodesByName(@PathVariable("node_name") String node_name,
                                      @PathVariable("node_level") String node_level) {
        return nodeService.findNodesByName(node_name, node_level);
    }

    @PostMapping(value = "/insertNode")
    public String insertChildNode(Integer node_id, String node_name, String node_desc) {
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
