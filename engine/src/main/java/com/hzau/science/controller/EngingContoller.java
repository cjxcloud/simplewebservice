package com.hzau.science.controller;

import com.alibaba.fastjson.JSONObject;
import com.hzau.science.service.EnginService;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by cjx on 2017/4/30.
 */
@Controller
@RequestMapping("/WsCloud/services")
public class EngingContoller {

    private static final Logger log = LoggerFactory.getLogger("EnginController");

    @Autowired
    private EnginService enginService;

   /*
    @RequestMapping("/listServices")
    public String serviceDispatcher( Map<String, Object> result){

        log.info("serviceDispatcher params:");
        //返回所有的service
        List<String> serviceNameList = enginService.getAllDeployedServices();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errno",0);
        jsonObject.put("errmsg", "success");
        jsonObject.put("data", serviceNameList);
        result.put("result", jsonObject);
        return "index";
    }
    */

    @RequestMapping("/listServices")
    @ResponseBody
    public JSONObject serviceDispatcher( Map<String, Object> result){

        log.info("serviceDispatcher params:");
        //返回所有的service
        List<String> serviceNameList = enginService.getAllDeployedServices();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errno",0);
        jsonObject.put("errmsg", "success");
        jsonObject.put("data", serviceNameList);
        result.put("result", jsonObject);
        return jsonObject;
    }

    @RequestMapping("/wsdl/{serviceName}")
    public void getserviceWsdl(@PathVariable("serviceName") String serviceName, @RequestParam(value = "wsdl",required = false)String wsdl,
            HttpServletRequest request, HttpServletResponse response) {

        log.info("serviceResolver params: serviceName={}, wsdl={}", serviceName, wsdl);
        String user = request.getHeader("SUPER_USER");
        String wsdlPath = enginService.getWSDLObject(serviceName);
        Document document = null;
        try{
            File wsdlFile = new File(wsdlPath);
            //创建SAXReader对象
            SAXReader reader = new SAXReader();
            //读取文件 转换成Document
            document = reader.read(wsdlFile);
            System.out.println(document.toString());
            response.setContentType("text/xml;charset=utf-8");
            response.setHeader("cache-control", "no-cache");
            XMLWriter w = new XMLWriter(response.getWriter());
            w.write(document);
            w.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/{serviceName}")
    public void serviceResolver(@PathVariable("serviceName") String serviceName,
                                HttpServletRequest request, HttpServletResponse response) {

        String str, wholeStr = "";
        //String testStr = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><add xmlns=\"\"><addln><x>20</x><y>3</y></addln></add></soapenv:Body></soapenv:Envelope>";
        try{
            BufferedReader br = request.getReader();
            while((str = br.readLine()) != null){
                wholeStr += str;
            }
            log.info("serviceResolver soapStr={}", wholeStr);

            Document documentRequest = DocumentHelper.parseText(wholeStr);
            Document documentResponse = enginService.resolveRequest(serviceName, documentRequest);
            response.setContentType("text/xml;charset=utf-8");
            response.setHeader("cache-control", "no-cache");
            XMLWriter w = new XMLWriter(response.getWriter());
            w.write(documentResponse);
            w.close();
        }catch (Exception e) {
            log.error("serviceResolver error! Exception={}", e);
        }
    }
}
