package com.hzau.cs.deployment.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cjx on 2017/5/1.
 */
@Component
public class ClassFileUtil {

    /**
     * 获取目录下的所有的pojo的类名称
     * @param directory
     * @return
     */
    public List<String> getClassNameList(String  directory){
        List<String> classNameList = new ArrayList<String>();

        File dir = new File(directory);
        File[] files = dir.listFiles();
        for (File file : files){
            if (file.getName().endsWith(".class")){
                classNameList.add(file.getName().substring(0,file.getName().length()-6));
            }
        }
        return classNameList;
    }

}
