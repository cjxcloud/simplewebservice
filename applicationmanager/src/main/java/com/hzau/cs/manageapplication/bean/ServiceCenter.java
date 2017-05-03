package com.hzau.cs.manageapplication.bean;

import com.hzau.cs.deployment.service.DeployService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


/**
 * Created by cjx on 2017/5/1.
 */
public class ServiceCenter implements InitializingBean{

    private static final Logger log = LoggerFactory.getLogger("ServiceCenter");

    @Autowired
    private DeployService deployService;

    public String pojoPath;

    public Map<String, Object> serviceCollection = null;

    public List<String> serviceNameLsit = null;

    public Map<String, String> serviceWsdlMap = null;

    public String getPojoPath() {
        return pojoPath;
    }

    public void setPojoPath(String pojoPath) {
        this.pojoPath = pojoPath;
    }

    public Map<String, Object> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Map<String, Object> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    public List<String> getServiceNameLsit() {
        return serviceNameLsit;
    }

    public void setServiceNameLsit(List<String> serviceNameLsit) {
        this.serviceNameLsit = serviceNameLsit;
    }

    public Map<String, String> getServiceWsdlMap() {
        return serviceWsdlMap;
    }

    public void setServiceWsdlMap(Map<String, String> serviceWsdlMap) {
        this.serviceWsdlMap = serviceWsdlMap;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        serviceNameLsit = deployService.getPojoServiceNameAll();
        serviceWsdlMap = deployService.getPojoServiceWsdlAll(serviceNameLsit);
        serviceCollection = deployService.getPojoServiceAll(serviceNameLsit);
        log.info("deployed service success. the services list={}", serviceNameLsit);
    }
}
