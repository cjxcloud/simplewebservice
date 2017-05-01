package com.hzau.cs.manageapplication.service.impl;

import com.hzau.cs.common.bean.soapbean.SoapRequestObject;
import com.hzau.cs.common.bean.soapbean.SoapResponseObject;
import com.hzau.cs.manageapplication.service.AppManagerService;

/**
 * Created by cjx on 2017/5/1.
 */
public class AppManagerServiceImpl implements AppManagerService {

    /**
     * 调用具体的service的方法
     * @param serviceName
     * @param soapRequestObject
     * @return
     */
    public SoapResponseObject invokeService(String serviceName, SoapRequestObject soapRequestObject){
        SoapResponseObject soapResponseObject = new SoapResponseObject();

        return soapResponseObject;
    }
}
