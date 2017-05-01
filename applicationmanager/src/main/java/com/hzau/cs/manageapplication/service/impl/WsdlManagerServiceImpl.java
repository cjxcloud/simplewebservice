package com.hzau.cs.manageapplication.service.impl;

import com.hzau.cs.common.bean.wsdlbean.WsdlObject;
import com.hzau.cs.manageapplication.service.WsdlManageService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cjx on 2017/5/1.
 */
public class WsdlManagerServiceImpl implements WsdlManageService {

    /**
     * 解析所有的service，生成对应的wsdl
     */
    public void paresAllServiceIntoWsdl(){

    }

    /**
     * 获取wsdl对象的list
     * @param serviceName
     * @return
     */
    public List<WsdlObject> getServiceWsdl(String serviceName){
        List<WsdlObject> wsdlObjectList = new ArrayList<WsdlObject>();

        return wsdlObjectList;
    }
}
