package com.hzau.cs.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.model.element.NestingKind;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cjx on 2017/5/3.
 */
public class SoapTest {

    private static final Logger log = LoggerFactory.getLogger("SoapTest");

/*
    public static void main(String[] args){

        WsClient wsClient = ClientFactory.getWsClient("http://localhost:8080/WsCloud/services/wsdl/WsService","WsService");

        Map<String, Object > parammeter = new HashMap<String, Object>();
        parammeter.put("arg1", 20);
        parammeter.put("arg2", 3);
        try{
            int soapResponse = Integer.parseInt((String) wsClient.invoke("add",parammeter, parammeter));
            log.info(String.valueOf(soapResponse));
        }catch (Exception e) {
            log.error("Exception = {}", e);
        }

    }
    */



    /*
    public static void main(String[] args) {

        WsClient wsClient = ClientFactory.getWsClient("http://localhost:8080/WsCloud/services/wsdl/WsService","WsService");

        Map<String, Object > parammeter = new HashMap<String, Object>();
        try{
            String soapResponse = (String) wsClient.invoke("hello",parammeter, parammeter);
            log.info(soapResponse);
        }catch (Exception e) {
            log.error("Exception = {}", e);
        }
    }
    */



    public static void main(String[] args) {

        WsClient wsClient = ClientFactory.getWsClient("http://localhost:8080/WsCloud/services/wsdl/WsService","WsService");

        Map<String, Object > parammeter = new HashMap<String, Object>();
        try{
            parammeter.put("arg1", "Jack");
            String soapResponse = (String) wsClient.invoke("helloSomeOne",parammeter, parammeter);
            log.info(soapResponse);
        }catch (Exception e) {
            log.error("Exception = {}", e);
        }
    }


}
