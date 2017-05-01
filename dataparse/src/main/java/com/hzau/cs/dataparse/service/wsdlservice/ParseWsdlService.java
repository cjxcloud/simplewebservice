package com.hzau.cs.dataparse.service.wsdlservice;

import com.hzau.cs.common.bean.wsdlbean.WsdlObject;
import com.hzau.cs.common.bean.wsdlbean.WsdlResponseObject;

/**
 * Created by cjx on 2017/5/1.
 */
public interface ParseWsdlService {

    /**
     * 解析service，生成对应的WSDL对象
     * @param serviceObject
     * @return
     */
    public WsdlObject parseServiceIntoWsdlObject(Object serviceObject);

    /**
     * 解析WSDL结果，生成对应的WSDL响应对象
     * @param wsdlObject
     * @return
     */
    public WsdlResponseObject parseIntoResponseObject(WsdlObject wsdlObject);
}
