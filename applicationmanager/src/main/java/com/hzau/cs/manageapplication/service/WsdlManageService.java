package com.hzau.cs.manageapplication.service;

import com.hzau.cs.common.bean.wsdlbean.WsdlObject;

import java.util.List;

/**
 * Created by cjx on 2017/5/1.
 */
public interface WsdlManageService {

    /**
     * 解析所有的service，生成对应的wsdl
     */
    public void paresAllServiceIntoWsdl();

    /**
     * 获取wsdl对象的list
     * @param serviceName
     * @return
     */
    public String getServiceWsdl(String serviceName);
}
