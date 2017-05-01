package com.hzau.science.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hzau.science.service.DeployedServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cjx on 2017/4/30.
 */
@RestController
public class EngingContoller {

    @Autowired
    private DeployedServices deployedServices;

    @RequestMapping("/services")
    public JSONObject serviceDispatcher(HttpServletRequest request){

        //返回所有的service
        JSONArray serviceJson = deployedServices.getAllDeployedServices();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errno",0);
        jsonObject.put("errmsg", "success");
        jsonObject.put("data", "[]");
        return jsonObject;
    }

    @RequestMapping("/serviceManage")
    public JSONObject serviceResolver(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errno",0);
        jsonObject.put("errmsg", "success");
        jsonObject.put("data", "[]");
        return jsonObject;
    }


}
