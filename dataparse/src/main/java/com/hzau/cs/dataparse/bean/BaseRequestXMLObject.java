package com.hzau.cs.dataparse.bean;

import java.util.Map;

/**
 * Created by cjx on 2017/4/30.
 */
public class BaseRequestXMLObject {

    public String serviceName;

    public String methodName;

    public Map<String, ParamObject> parammeter;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Map<String, ParamObject> getParammeter() {
        return parammeter;
    }

    public void setParammeter(Map<String, ParamObject> parammeter) {
        this.parammeter = parammeter;
    }

    public static class ParamObject{


        public String type;
        public Object value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

    }

}
