package com.hzau.cs.manageapplication.service;

import com.hzau.cs.dataparse.bean.BaseRequestXMLObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;

/**
 * Created by cjx on 2017/5/1.
 */
public interface AppManagerService {

    /**
     * 解析请求的SOAP报文
     * @param serviceName
     * @param document
     * @return
     */
    public BaseRequestXMLObject praseRequestXML(String serviceName, Document document);

    /**
     * 调用具体的service的方法,返回结果对象
     * @param baseRequestXMLObject
     * @return
     */
    public Object invokeService(BaseRequestXMLObject baseRequestXMLObject);

    /**
     * 生成相应的SOAP的dom对象
     * @param methodName
     * @param object
     * @return
     */
    public Document parseResponseXML(String methodName, Object object) throws DocumentException;
}
