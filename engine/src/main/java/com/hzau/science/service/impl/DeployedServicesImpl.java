package com.hzau.science.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.hzau.science.bean.BaseResponseXMLObject;
import com.hzau.science.bean.WSDLXMLBean;
import com.hzau.science.service.DeployedServices;
import org.springframework.stereotype.Service;

/**
 * Created by cjx on 2017/4/30.
 */
@Service
public class DeployedServicesImpl implements DeployedServices{
    /**
     * 列举出所有的service
     */
    public JSONArray getAllDeployedServices(){
        JSONArray ret = new JSONArray();

        return ret;
    }

    /**
     * 给出特定的services的WSDL文件
     */

    public WSDLXMLBean getWSDLObject(String serviceName){
        WSDLXMLBean wsdlxmlBean = new WSDLXMLBean();

        return  wsdlxmlBean;
    }

    /**
     * 处理具体的请求
     */

    public BaseResponseXMLObject resolveRequest(BaseResponseXMLObject baseResponseXMLObject){
        BaseResponseXMLObject baseResponseXMLObject1 = new BaseResponseXMLObject();

        return  baseResponseXMLObject;
    }

}
