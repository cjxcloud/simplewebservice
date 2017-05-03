package com.hzau.science.service.impl;

import com.hzau.cs.deployment.service.DeployService;
import com.hzau.cs.manageapplication.service.AppDeployedService;
import com.hzau.cs.manageapplication.service.WsdlManageService;
import com.hzau.science.bean.BaseResponseXMLObject;
import com.hzau.science.bean.WSDLXMLBean;
import com.hzau.science.service.EnginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cjx on 2017/4/30.
 */
@Service
public class EnginServiceImpl implements EnginService {

    @Autowired
    private WsdlManageService wsdlManageService;

    @Autowired
    private DeployService deployService;

    /**
     * 列举出所有的service
     */
    public List<String> getAllDeployedServices(){
        List<String> serviceNameList = deployService.getPojoServiceNameAll();

        return serviceNameList;
    }

    /**
     * 给出特定的services的WSDL文件
     */

    public String getWSDLObject(String serviceName){

        String wsdlPath = wsdlManageService.getServiceWsdl(serviceName);

        return  wsdlPath;
    }

    /**
     * 处理具体的请求
     */

    public BaseResponseXMLObject resolveRequest(BaseResponseXMLObject baseResponseXMLObject){
        BaseResponseXMLObject baseResponseXMLObject1 = new BaseResponseXMLObject();

        return  baseResponseXMLObject;
    }

}
