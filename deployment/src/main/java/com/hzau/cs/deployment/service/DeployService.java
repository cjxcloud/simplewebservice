package com.hzau.cs.deployment.service;
import java.util.Map;

/**
 * Created by cjx on 2017/5/1.
 */
public interface DeployService {

    /**
     * 启动时加载部署所有的POJO形式的service
     * @return map
     */
    public Map<String, Object> getPojoServiceAll();
}
