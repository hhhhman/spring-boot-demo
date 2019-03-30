package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }

    /**
     * 1.创建JedisPoolConfig对象，在该对象中完成一些连接池的配置
     *
     */
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config=new JedisPoolConfig();
        //最大空闲数
        config.setMaxIdle(10);
        //最小空闲数
        config.setMinIdle(5);
        //最大链接数
        config.setMaxTotal(20);
        return config;
    }

    /**
     * 2.创建JedisConnectionFactory:配置redis连接信息
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config){
        JedisConnectionFactory factory=new JedisConnectionFactory();
        //关联连接池的配置对象
        factory.setPoolConfig(config);
        //配置连接redis的信息
        factory.setHostName("127.0.0.1");
        //设置端口
        factory.setPort(6379);
        return factory;
    }

    /**
     * 3.创建RedisTemplate,里面封装了对redis操作的api
     * 作用：用于执行redis操作的方法
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory factory){
        RedisTemplate<String,Object> template=new RedisTemplate<>();
        //关联
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        return template;
    }
}
