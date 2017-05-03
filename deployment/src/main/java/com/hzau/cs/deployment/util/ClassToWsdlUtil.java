package com.hzau.cs.deployment.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cjx on 2017/5/2.
 */
@Component
public class ClassToWsdlUtil {

    public Map<String, String> parseClassToWsdlFile(String path, List<String> serviceNameList){
        Map<String, String> map = new HashMap<String, String>();
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (File file : files){
            if (file.getName().endsWith(".wsdl")){
                map.put(file.getName().substring(0,file.getName().length()-5),file.getAbsolutePath());
            }
        }
        return map;
    }
}
