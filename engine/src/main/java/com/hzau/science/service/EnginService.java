package com.hzau.science.service;

import com.hzau.cs.dataparse.bean.BaseResponseXMLObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;

import java.util.List;

/**
 * Created by cjx on 2017/4/30.
 */
public interface EnginService {

    /**
     * 列举出所有的service
     */
    public List<String> getAllDeployedServices();

    /**
     * 给出特定的services的WSDL文件
     */

    public String getWSDLObject(String serviceName);

    /**
     * 处理具体的请求
     */

    public Document resolveRequest(String serviceName, Document document) throws DocumentException;

}
