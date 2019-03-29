package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.demo.bean.Node;

public interface NodeMapper {

    @Select("select * from node WHERE node_pid =0")
    public List<Node> selectNodeAll();

    @Select("select * from node WHERE  node_pid =0 and node_name like '%${nodename}%'")
    public List<Node> selectName(@Param("nodename") String nodename);

    @Select("SELECT count(node_level) from node where node_level not like '%.%'")
    public String countByLevel();

    @Insert("insert into node values (null, #{count}, #{node_name}, '使用中', #{node_desc}, 0)")
    public int addNode(@Param("node_name") String node_name, @Param("node_desc") String node_desc, @Param("count") String count);

    //	查询语句相关
    @Select("select node_level from node where node_name like '%${node_name}%' and node_level rlike '^${node_level}.*'")
    public List<String> selectLevelsByName(@Param("node_name") String node_name,
                                           @Param("node_level") String node_level);

    @Select("select node_level from node where node_pid in (select node_id from node where node_name like '%${node_name}%' and node_level rlike '^${node_level}.*')")
    public List<String> selectChildLevelsByName(@Param("node_name") String node_name,
                                                @Param("node_level") String node_level);

    @Select("select node_id, node_level, node_name, node_state, node_desc, node_pid from node where node_level = #{node_level}")
    public Node selectNodeByLevel(@Param("node_level") String node_level);

    //	点击一次查询一次子结点
    @Select("select node_id, node_level, node_name, node_state, node_desc, node_pid from node where node_pid =#{node_id} or node_id =#{node_id}")
    public List<Node> selectChildNodesById(@Param("node_id") Integer node_id);

    //	新增语句相关
    @Select("select node_level from node where node_pid = #{node_id}")
    public List<String> selectChildLevelsById(@Param("node_id") Integer id);

    @Insert("insert into node values (null, #{node_level}, #{node_name}, '使用中', #{node_desc}, #{node_pid})")
    public void insertChildNode(@Param("node_level") String node_level, @Param("node_name") String node_name,
                                @Param("node_desc") String node_desc, @Param("node_pid") Integer node_pid);

    @Select("select node_level from node where node_id = #{node_id}")
    public String selectLevelById(@Param("node_id") Integer node_id);

    //	修改语句相关
    @Update("update node set node_name = #{node_name}, node_desc = #{node_desc} where node_id = #{node_id}")
    public void updateNodeById(@Param("node_name") String node_name, @Param("node_desc") String node_desc,
                               @Param("node_id") Integer node_id);

    //	删除语句相关
    @Delete("delete from node where node_id = #{node_id}")
    public void deleteNodeById(@Param("node_id") Integer node_id);

    @Update(("update node set node_state = '已删除' where node_id = #{node_id}"))
    public void updateStateById(@Param("node_id") Integer node_id);

}
