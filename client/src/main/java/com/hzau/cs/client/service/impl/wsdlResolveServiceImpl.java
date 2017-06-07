package com.hzau.cs.client.service.impl;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

/**
 * Created by cjx on 2017/5/3.
 */

public class wsdlResolveServiceImpl {

    private final static Logger log = LoggerFactory.getLogger("wsdlResolveServiceImpl");

    /*
    public static void main(String[] args){
        String wsdlResponseData = null;
        try{
            PostMethod postMethod = new PostMethod("http://localhost:8080/WsCloud/services/wsdl/WsService");
            HttpClient httpClient = new HttpClient();
            int statusCode = httpClient.executeMethod(postMethod);
            wsdlResponseData = postMethod.getResponseBodyAsString();
            log.info(wsdlResponseData);
            new wsdlResolveServiceImpl().parseWsdlResponseData(wsdlResponseData);
        }catch (Exception e){
            log.error("invoke wsdl Exception={}", e);
        }
    }
    */

    public String getAddress(String wsdlPath){
        String addressPath = null;
        try{
            PostMethod postMethod = new PostMethod(wsdlPath);
            HttpClient httpClient = new HttpClient();
            int statusCode = httpClient.executeMethod(postMethod);
            String wsdlResponseData = postMethod.getResponseBodyAsString();
            log.info(wsdlResponseData);
            addressPath = (String)new wsdlResolveServiceImpl().parseWsdlResponseData(wsdlResponseData);
        }catch (Exception e){
            log.error("invoke wsdl Exception={}", e);
        }

        return  addressPath;
    }

    private Object parseWsdlResponseData(String wsdlResponseData) throws Exception {

        Object result = null;
        try{
            Document wsdlDocument = DocumentHelper.parseText(wsdlResponseData);
            Element eDefinition = wsdlDocument.getRootElement();
            Iterator<Element> definiionIterator = eDefinition.elementIterator();
            while(definiionIterator.hasNext()){
                Element element = definiionIterator.next();
                log.info(element.getName());
                if (element.getName().equals("service")){
                    Iterator<Element> serviceIterator = element.elementIterator();
                    Element ePort = serviceIterator.next();
                    Iterator<Element> portIterator = ePort.elementIterator();
                    Element eAddress = portIterator.next();
                    log.info(eAddress.getName());
                    log.info(eAddress.attributeValue("location"));
                    result = eAddress.attributeValue("location");
                }
            }
        }catch (Exception e) {
            log.error("parseWsdlResponseData Exception={}", e);
            throw e;
        }

        return result;
    }
}
