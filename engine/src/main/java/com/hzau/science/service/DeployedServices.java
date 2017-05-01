package com.hzau.science.service;

import com.alibaba.fastjson.JSONArray;
import com.hzau.science.bean.WSDLXMLBean;
import com.hzau.science.bean.BaseResponseXMLObject;
/**
 * Created by cjx on 2017/4/30.
 */
public interface DeployedServices {

    /**
     * 列举出所有的service
     */
    public JSONArray getAllDeployedServices();

    /**
     * 给出特定的services的WSDL文件
     */

    public WSDLXMLBean getWSDLObject(String serviceName);

    /**
     * 处理具体的请求
     */

    public BaseResponseXMLObject resolveRequest(BaseResponseXMLObject baseResponseXMLObject);

}
