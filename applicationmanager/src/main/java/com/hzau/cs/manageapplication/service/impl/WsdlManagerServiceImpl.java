package com.hzau.cs.manageapplication.service.impl;

import com.hzau.cs.manageapplication.bean.ServiceCenter;
import com.hzau.cs.manageapplication.service.WsdlManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by cjx on 2017/5/1.
 */
@Component
public class WsdlManagerServiceImpl implements WsdlManageService {

    @Autowired
    private ServiceCenter serviceCenter;

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
    public String getServiceWsdl(String serviceName){
       /* List<String> wsdlObjectList = new ArrayList<String>();
        List<String> serviceNameList = deployService.getPojoServiceNameAll();
        System.out.println(wsdlObjectList.toString());
        String wsdlPath = deployService.getPojoServiceWsdlAll(serviceNameList).get(serviceName);
        wsdlObjectList .add(wsdlPath);

        System.out.println(wsdlObjectList.toString());*/
        return serviceCenter.getServiceWsdlMap().get(serviceName);
    }
}
