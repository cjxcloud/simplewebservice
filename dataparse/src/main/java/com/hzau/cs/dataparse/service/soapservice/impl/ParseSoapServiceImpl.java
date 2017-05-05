package com.hzau.cs.dataparse.service.soapservice.impl;

import com.hzau.cs.dataparse.bean.BaseRequestXMLObject;
import com.hzau.cs.dataparse.bean.BaseRequestXMLObject.ParamObject;
import com.hzau.cs.dataparse.bean.BaseResponseXMLObject;
import com.hzau.cs.dataparse.service.soapservice.ParseSoapService;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by cjx on 2017/5/1.
 */
@Component
public class ParseSoapServiceImpl implements ParseSoapService {

    /**
     * 将SOAP请求对象转成对应的服务对象
     * @return
     */
    public BaseRequestXMLObject parseIntoSoapRequestObject(Document document){

        Element root = document.getRootElement();
        BaseRequestXMLObject baseRequestXMLObject = listNodes(root);
        return baseRequestXMLObject;
    }

    /**
     * 将服务对象转换成对应的SOAP响应对象
     * @param baseResponseXMLObject
     * @return
     */
    public Document parseIntoSoapResponseObject(BaseResponseXMLObject baseResponseXMLObject) throws DocumentException {

        Document document = DocumentHelper.parseText("");
        return  document;
    }

    //遍历当前节点下的所有节点
    private BaseRequestXMLObject listNodes(Element node){
        BaseRequestXMLObject baseRequestXMLObject = new BaseRequestXMLObject();
        Map<String, BaseRequestXMLObject.ParamObject> param = new HashMap<String, BaseRequestXMLObject.ParamObject>();
        ParamObject paramObject = new ParamObject();
        System.out.println("当前节点的名称：" + node.getName());

        Iterator<Element> iteratorEnvelope = node.elementIterator();
        Element eBody = iteratorEnvelope.next();
        Iterator<Element> iteratorBody = eBody.elementIterator();
        Element eMethod = iteratorBody.next();
        baseRequestXMLObject.setMethodName(eMethod.getName());
        Iterator<Element> iteratorMethod = eMethod.elementIterator();
        Element eMethodln = iteratorMethod.next();
        Iterator<Element> iteratorMethodln = eMethodln.elementIterator();
        while(iteratorMethodln.hasNext()){
            Element eParam = iteratorMethodln.next();
            System.out.println("Data: "+eParam.getData()+"; Namespace: "+ eParam.getNamespace()+"; QName: "+eParam.getQName());
            if (!(eParam.getTextTrim().equals(""))) {
                paramObject.setValue(eParam.getText());
                param.put(eParam.getName(), paramObject);
            }
        }
        baseRequestXMLObject.setParammeter(param);
        return baseRequestXMLObject;
    }

}
