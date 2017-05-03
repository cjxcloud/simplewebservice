package com.hzau.cs.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cjx on 2017/5/3.
 */
public class ClientFactory {

    private static final Logger log = LoggerFactory.getLogger("ClientFactory");

    public static WsClient getWsClient(String wsdlPath,String ns) {
        log.info("getWsClient params: wsdlPath={}, ns={}", wsdlPath, ns);
        return new WsClient(wsdlPath, ns);
    }
}
