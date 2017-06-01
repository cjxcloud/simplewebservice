package com.hzau.cs.manageapplication.service.impl;

import com.hzau.cs.dataparse.bean.BaseRequestXMLObject;
import com.hzau.cs.dataparse.service.soapservice.ParseSoapService;
import com.hzau.cs.manageapplication.bean.ServiceCenter;
import com.hzau.cs.manageapplication.service.AppManagerService;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by cjx on 2017/5/1.
 */
@Service
public class AppManagerServiceImpl implements AppManagerService {

    private static final Logger log = LoggerFactory.getLogger("AppManagerServiceImple");

    @Autowired
    private ParseSoapService parseSoapService;

    @Autowired
    private ServiceCenter serviceCenter;

    /**
     * 调用具体的service的方法
     * @param serviceName
     * @param document
     * @return
     */
    public BaseRequestXMLObject praseRequestXML(String serviceName, Document document){

        BaseRequestXMLObject baseRequestXMLObject = parseSoapService.parseIntoSoapRequestObject(document);
        baseRequestXMLObject.setServiceName(serviceName);
        return baseRequestXMLObject;
    }

    /**
     * 调用具体的service的方法,返回结果对象
     * @param baseRequestXMLObject
     * @return
     */
    public Object invokeService(BaseRequestXMLObject baseRequestXMLObject){

        Object result = null;
        Class<?> cls = (Class<?>) serviceCenter.getServiceCollection().get(baseRequestXMLObject.getServiceName());
        Map<String, BaseRequestXMLObject.ParamObject> param = baseRequestXMLObject.getParammeter();
        try{
            Object instance = cls.newInstance();
            Method[] methods = cls.getMethods();
            Method method = null;
            if (param.isEmpty()){
                method = cls.getMethod(baseRequestXMLObject.getMethodName());
                result = method.invoke(instance);
            }else if (param.get("arg1").getType().equals("int")){

                method = cls.getMethod(baseRequestXMLObject.getMethodName(),int.class, int.class);

                result = method.invoke(instance, Integer.parseInt(param.get("arg1").getValue().toString()), Integer.parseInt(param.get("arg2").getValue().toString()));

            }else if (param.get("arg1").getType().equals("String")){

                method = cls.getMethod(baseRequestXMLObject.getMethodName(),String.class);
                result = method.invoke(instance, param.get("arg1").getValue());
            }
            log.info("invokeAddService result={}",result);
        }catch (Exception e){
            log.error("Exception={}", e);
        }
        log.info("invokeService serviceName={}, object={}", baseRequestXMLObject.getServiceName(), cls);
        return result;
    }

    /**
     * 生成相应的SOAP的dom对象
     * @param methodName
     * @param object
     * @return
     */
    public Document parseResponseXML(String methodName, Object object) throws DocumentException {

        String soapStr = buildResponseSoap(methodName, object);
        Document documentResponse = DocumentHelper.parseText(soapStr);
        return documentResponse;
    }

    private String buildResponseSoap(String methodName, Object object) {

        StringBuilder soapStr = new StringBuilder();
        soapStr.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        soapStr.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\""
                + " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\""
                + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
        soapStr.append("<soapenv:Body>");
        soapStr.append("<" + methodName + "Response>");
        soapStr.append("<" + methodName + "Return>");
        soapStr.append(object);
        soapStr.append("</" + methodName + "Return>");
        soapStr.append("</" + methodName + "Response>");
        soapStr.append("</soapenv:Body>");
        soapStr.append("</soapenv:Envelope>");
        return soapStr.toString();
    }
}
