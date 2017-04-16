package com.hzau.science.client;

import com.hzau.science.client.impl.Client;

/**
 * Created by chenjiaxiong on 2017/4/16.
 */
public class ClientFactory {

    public static ClientFactory newInstance(){
        return new ClientFactory();
    }


    public WebServiceClient createClient(String url){
        return new Client(url);
    }
}
