package com.hzau.cs.dataparse.service.soapservice.impl;

import com.hzau.cs.common.bean.servicebean.ServiceObject;
import com.hzau.cs.common.bean.soapbean.SoapResponseObject;
import com.hzau.cs.dataparse.service.soapservice.ParseSoapService;

/**
 * Created by cjx on 2017/5/1.
 */
public class ParseSoapServiceImpl implements ParseSoapService {

    /**
     * 将SOAP请求对象转成对应的服务对象
     * @return
     */
    public ServiceObject parseIntoSoapRequestObject(SoapResponseObject soapResponseObject){
        ServiceObject serviceObject = new ServiceObject();

        return serviceObject;
    }

    /**
     * 将服务对象转换成对应的SOAP响应对象
     * @param serviceObject
     * @return
     */
    public SoapResponseObject parseIntoSoapResponseObject(ServiceObject serviceObject){
        SoapResponseObject soapResponseObject = new SoapResponseObject();

        return  soapResponseObject;
    }
}
