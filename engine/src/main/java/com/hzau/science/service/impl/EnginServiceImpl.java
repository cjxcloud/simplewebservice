package com.hzau.science.service.impl;

import com.hzau.cs.dataparse.bean.BaseRequestXMLObject;
import com.hzau.cs.deployment.service.DeployService;
import com.hzau.cs.manageapplication.service.AppDeployedService;
import com.hzau.cs.manageapplication.service.AppManagerService;
import com.hzau.cs.manageapplication.service.WsdlManageService;
import com.hzau.science.service.EnginService;
import org.dom4j.Document;
import org.dom4j.DocumentException;
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
    private AppManagerService appManagerService;

    @Autowired
    private AppDeployedService appDeployedService;

    /**
     * 列举出所有的service
     */
    public List<String> getAllDeployedServices(){

        List<String> serviceNameList = appDeployedService.getDeployedServices();
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
    public Document resolveRequest(String serviceName, Document document) throws DocumentException {

        BaseRequestXMLObject baseRequestXMLObject = appManagerService.praseRequestXML(serviceName, document);
        Object serviceResult = appManagerService.invokeService(baseRequestXMLObject);

        //Document documentResponse = appManagerService.parseResponseXML(baseRequestXMLObject.getMethodName(),serviceResult);

        Document documentResponse = appManagerService.parseResponseXML("add",serviceResult);
        return  documentResponse;
    }

}
