package com.hzau.cs.deployment.service.impl;

import com.hzau.cs.deployment.service.DeployService;
import com.hzau.cs.deployment.util.ClassFileUtil;
import com.hzau.cs.deployment.util.ClassLoaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cjx on 2017/5/1.
 */
@Service
public class DeployServiceImpl implements DeployService {

    @Autowired
    private ClassLoaderUtil classLoaderUtil;

    @Autowired
    private ClassFileUtil classFileUtil;

    /**
     * 启动时加载部署所有的POJO形式的service
     * @return map
     */
    public Map<String, Object> getPojoServiceAll(){
        List<String> serviceNameList = classFileUtil.getClassNameList("E:/test");
        Map<String, Object> serviceMap = classLoaderUtil.getServiceList(serviceNameList);

        return serviceMap;
    }
}
