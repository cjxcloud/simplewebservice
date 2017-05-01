package com.hzau.cs.dataparse.service.wsdlservice.impl;

import com.hzau.cs.common.bean.wsdlbean.WsdlObject;
import com.hzau.cs.common.bean.wsdlbean.WsdlResponseObject;
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
    public WsdlObject parseServiceIntoWsdlObject(Object serviceObject){
        WsdlObject wsdlObject = new WsdlObject();

        return  wsdlObject;
    }

    /**
     * 解析WSDL结果，生成对应的WSDL响应对象
     * @param wsdlObject
     * @return
     */
    public WsdlResponseObject parseIntoResponseObject(WsdlObject wsdlObject){
        WsdlResponseObject wsdlResponseObject = new WsdlResponseObject();

        return  wsdlResponseObject;
    }
}
