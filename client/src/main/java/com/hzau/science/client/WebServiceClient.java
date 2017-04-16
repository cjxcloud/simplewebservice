package com.hzau.science.client;

import org.omg.CORBA.Object;

/**
 * Created by chenjiaxiong on 2017/4/16.
 */
public interface WebServiceClient {

    Object[] invoke(String methodName, Object... var2) throws Exception;

}
