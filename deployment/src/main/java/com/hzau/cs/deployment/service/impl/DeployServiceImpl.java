package com.hzau.cs.deployment.service.impl;

import com.hzau.cs.deployment.service.DeployService;
import com.hzau.cs.deployment.util.ClassFileUtil;
import com.hzau.cs.deployment.util.ClassLoaderUtil;
import com.hzau.cs.deployment.util.ClassToWsdlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cjx on 2017/5/1.
 */
@Component
public class DeployServiceImpl implements DeployService {

    @Autowired
    private ClassLoaderUtil classLoaderUtil;

    @Autowired
    private ClassFileUtil classFileUtil;

    @Autowired
    private ClassToWsdlUtil classToWsdlUtil;

    /**
     * 启动时加载部署所有的POJO形式的service
     * @return map
     */
    public Map<String, Object> getPojoServiceAll(List<String> serviceNameList){
        Map<String, Object> serviceMap = classLoaderUtil.getServiceList("E:/test",serviceNameList);
        return serviceMap;
    }

    /**
     * 启动时加载部署所有的POJO形式的serviceName
     * @return
     */
    public List<String> getPojoServiceNameAll(){
        List<String> serviceNameList = classFileUtil.getClassNameList("E:/test");

        return serviceNameList;
    }

    /**
     * 启动时加载部署所有的POJO形式的serviceWsdl
     * @param serviceNameList
     * @return
     */
    public Map<String, String> getPojoServiceWsdlAll(List<String> serviceNameList){
        Map<String, String> wsdlMap =classToWsdlUtil.parseClassToWsdlFile("E:/test",serviceNameList);

        return  wsdlMap;
    }
}
