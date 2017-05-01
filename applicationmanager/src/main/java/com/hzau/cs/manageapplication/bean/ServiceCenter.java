package com.hzau.cs.manageapplication.bean;

import java.util.List;
import java.util.Map;

/**
 * Created by cjx on 2017/5/1.
 */
public class ServiceCenter {

    private Map<String, Object> serviceCollection = null;

    private List<String> serviceNameLsit = null;

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


}
