package com.hzau.cs.manageapplication.service.impl;

import com.hzau.cs.deployment.service.DeployService;
import com.hzau.cs.manageapplication.service.AppDeployedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by cjx on 2017/5/1.
 */
@Component
public class AppDeployedServiceImpl implements AppDeployedService{

    @Autowired
    private DeployService deployService;

    /**
     * 给上层调用，初始化service
     */
    public void makeServiceDeployed(){

    }
}
