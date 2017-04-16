package com.hzau.science.client.impl;

import com.hzau.science.client.WebServiceClient;
import org.omg.CORBA.Object;

/**
 * Created by chenjiaxiong on 2017/4/16.
 */
public class Client implements WebServiceClient {

    private String url;

    public Client(String url){
        this.url = url;
    }

    public Object[] invoke(String methodName, Object... var2) throws Exception {
        Object[] ret = new Object[0];

        return ret;
    }
}
