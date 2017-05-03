package com.hzau.science.controller;

import com.alibaba.fastjson.JSONObject;
import com.hzau.science.service.EnginService;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * Created by cjx on 2017/4/30.
 */
@RestController
public class EngingContoller {

    private static final Logger log = LoggerFactory.getLogger("EnginController");

    @Autowired
    private EnginService enginService;

    @RequestMapping("/listServices")
    public JSONObject serviceDispatcher(HttpServletRequest request, HttpServletResponse response){

        log.info("serviceDispatcher params:");
        //返回所有的service
        List<String> serviceNameList = enginService.getAllDeployedServices();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errno",0);
        jsonObject.put("errmsg", "success");
        jsonObject.put("data", serviceNameList);
        return jsonObject;
    }

    @RequestMapping("/serviceManage")
    public void serviceResolver(@RequestParam(value = "serviceName", required = true) String serviceName, HttpServletRequest request, HttpServletResponse response)  {

        log.info("serviceResolver params: serviceName={}", serviceName);
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

    @RequestMapping("/hello")
    public JSONObject hello(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("errno",0);
        jsonObject.put("errmsg", "success");
        jsonObject.put("data", "[]");
        return jsonObject;
    }


}
