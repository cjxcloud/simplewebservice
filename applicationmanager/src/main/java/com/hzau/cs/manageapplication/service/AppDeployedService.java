package com.hzau.cs.manageapplication.service;

import java.util.List;

/**
 * Created by cjx on 2017/5/1.
 */
public interface AppDeployedService {

    /**
     * 给上层调用，初始化service
     */
    public List<String> getDeployedServices();
}
