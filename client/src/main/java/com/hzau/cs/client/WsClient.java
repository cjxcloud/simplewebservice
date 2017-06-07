package com.hzau.cs.client;

import com.hzau.cs.client.service.impl.wsdlResolveServiceImpl;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by cjx on 2017/5/3.
 */
public class WsClient {

    private static final Logger log = LoggerFactory.getLogger("WsClient");

    private String namespace;
    //private String wsdlLocation;
    private String addressPath;
    private String soapResponseData;

    public WsClient(String wsdlPath,String ns) {
        this.addressPath = new wsdlResolveServiceImpl().getAddress(wsdlPath);
        this.namespace = ns;
    }

    public Object invoke(String methodName, Map<String, Object> parameterMap, Map<String, Object> parameterType) throws IOException {

        log.info("invoke params: methodName={}, parameterMap={}", methodName, parameterMap);

        PostMethod postMethod = new PostMethod(addressPath);
        String soapRequestData = buildRequestSOAP(methodName, parameterMap, parameterType);

        byte[] bytes = soapRequestData.getBytes("utf-8");
        InputStream inputStream = new ByteArrayInputStream(bytes, 0, bytes.length);
        RequestEntity requestEntity = new InputStreamRequestEntity(inputStream,
                bytes.length, "application/soap+xml; charset=utf-8");
        postMethod.setRequestEntity(requestEntity);
        HttpClient httpClient = new HttpClient();
        int statusCode = httpClient.executeMethod(postMethod);
        soapResponseData = postMethod.getResponseBodyAsString();
        log.info(soapResponseData);
        //return  soapResponseData;
        return parseSoapResponse(soapResponseData);
    }

    private String buildRequestSOAP(String methodName,Map<String, Object> parameterMap, Map<String, Object> parameterTypeMap) {
        StringBuilder soap=new StringBuilder(); //构造请求报文
        soap.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        soap.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\""
                + " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\""
                + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
        soap.append("<soapenv:Body>");
        soap.append("<" + methodName + " xmlns=\"" + namespace + "\">");
        soap.append("<" + methodName + "ln>");
        Set<String> nameSet = parameterMap.keySet();
        for (String name : nameSet) {
           soap.append("<" + name + ">" + parameterMap.get(name)
                  + "</" + name + ">");
        }
        soap.append("</" + methodName + "ln>");
        soap.append("</" + methodName + ">");
        soap.append("</soapenv:Body>");
        soap.append("</soapenv:Envelope>");
        log.info("buildRequestSOAP soapString={}", soap);
        return soap.toString();
    }

    private Object parseSoapResponse(String soapResponseData){

        Object result = null;
        try{
            Document responseDocument = DocumentHelper.parseText(soapResponseData);
            Element root = responseDocument.getRootElement();
            Iterator<Element> iteratorEnvelope = root.elementIterator();
            Element eBody = iteratorEnvelope.next();
            Iterator<Element> iteratorBody = eBody.elementIterator();
            Element eResponse = iteratorBody.next();
            Iterator<Element> iteratorResponse = eResponse.elementIterator();
            Element  eReturn = iteratorResponse.next();
            result = eReturn.getText();
        }catch (Exception e){
            log.info("parseSoapResponse Exception={}", e);
        }
        return  result;
    }

}
