package com.hzau.cs.dataparse.service.wsdlservice.impl;

import com.hzau.cs.dataparse.bean.BaseRequestXMLObject;
import com.hzau.cs.dataparse.bean.WSDLXMLBean;
import com.hzau.cs.dataparse.service.wsdlservice.ParseWsdlService;

/**
 * Created by cjx on 2017/5/1.
 */
public class ParseWsdlServiceImpl implements ParseWsdlService {

    /**
     * 解析service，生成对应的WSDL对象
     * @param serviceObject
     * @return
     */
    public WSDLXMLBean parseServiceIntoWsdlObject(Object serviceObject){
        WSDLXMLBean wsdlObject = new WSDLXMLBean();

        return  wsdlObject;
    }

    /**
     * 解析WSDL结果，生成对应的WSDL响应对象
     * @param wsdlObject
     * @return
     */
    public BaseRequestXMLObject parseIntoResponseObject(WSDLXMLBean wsdlObject){
        BaseRequestXMLObject wsdlResponseObject = new BaseRequestXMLObject();

        return  wsdlResponseObject;
    }
}
