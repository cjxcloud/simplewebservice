package com.hzau.cs.manageapplication.service;

import com.hzau.cs.common.bean.soapbean.SoapRequestObject;
import com.hzau.cs.common.bean.soapbean.SoapResponseObject;

/**
 * Created by cjx on 2017/5/1.
 */
public interface AppManagerService {

    /**
     * 调用具体的service的方法
     * @param serviceName
     * @param soapRequestObject
     * @return
     */
    public SoapResponseObject invokeService(String serviceName, SoapRequestObject soapRequestObject);
}
