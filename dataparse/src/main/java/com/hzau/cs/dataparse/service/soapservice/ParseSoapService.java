package com.hzau.cs.dataparse.service.soapservice;

import com.hzau.cs.common.bean.servicebean.ServiceObject;
import com.hzau.cs.common.bean.soapbean.SoapResponseObject;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLObject;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cjx on 2017/5/1.
 */
public interface ParseSoapService {

    /**
     * 将SOAP请求对象转成对应的服务对象
     * @return
     */
    public ServiceObject parseIntoSoapRequestObject(SoapResponseObject soapResponseObject);

    /**
     * 将服务对象转换成对应的SOAP响应对象
     * @param serviceObject
     * @return
     */
    public SoapResponseObject parseIntoSoapResponseObject(ServiceObject serviceObject);
}
