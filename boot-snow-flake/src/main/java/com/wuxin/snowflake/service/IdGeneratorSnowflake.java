package com.wuxin.snowflake.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Emma Watson
 * @create 2020-05-12 11:03
 */
@Component
@Slf4j
public class IdGeneratorSnowflake {

    private long workerId = 0;
    private long datacenterId = 1;
    private Snowflake snowflake = IdUtil.createSnowflake(workerId,datacenterId);

    /**
     * @PostConstruct 用法
     * 如果想在生成对象时候完成某些初始化操作，而偏偏这些初始化操作又依赖于依赖注入，
     * 那么就无法在构造函数中实现。
     * 为此，可以使用@PostConstruct注解一个方法来完成初始化，
     * @PostConstruct注解的方法将会在依赖注入完成后被自动调用。
     *
     * Constructor >> @Autowired >> @PostConstruct(主要是初始化作用)
     */
    @PostConstruct
    public void init(){

        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workId:{}",workerId);
        }catch (Exception e){
            log.warn("当前机器的workerId获取失败",e);
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
    }


    public synchronized long snowflakeId(){

        return snowflake.nextId();
    }

    public synchronized long snowflakeId(long workerId,long datacenterId){

        Snowflake snowflake = IdUtil.createSnowflake(workerId,datacenterId);
        return snowflake.nextId();
    }

    public static void main(String[] args) {

        System.out.println(new IdGeneratorSnowflake().snowflakeId());
    }
}
