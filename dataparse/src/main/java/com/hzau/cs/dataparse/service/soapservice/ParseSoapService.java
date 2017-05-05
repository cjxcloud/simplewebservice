package com.hzau.cs.dataparse.service.soapservice;

import com.hzau.cs.dataparse.bean.BaseRequestXMLObject;
import com.hzau.cs.dataparse.bean.BaseResponseXMLObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;

/**
 * Created by cjx on 2017/5/1.
 */
public interface ParseSoapService {

    /**
     * 将SOAP请求对象转成对应的服务对象
     * @return
     */
    public BaseRequestXMLObject parseIntoSoapRequestObject(Document document);

    /**
     * 将服务对象转换成对应的SOAP响应对象
     * @param baseResponseXMLObject
     * @return
     */
    public Document parseIntoSoapResponseObject(BaseResponseXMLObject baseResponseXMLObject) throws DocumentException;
}
