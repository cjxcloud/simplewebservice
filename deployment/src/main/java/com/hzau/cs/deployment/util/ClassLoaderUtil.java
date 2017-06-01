package com.hzau.cs.deployment.util;

import org.springframework.stereotype.Component;

import org.apache.cxf.tools.java2ws.JavaToWS;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by cjx on 2017/5/1.
 */

@Component
public class ClassLoaderUtil {

    public Map<String, Object> getServiceList(String path, String ip, List<String> serviceClassNameList) {
        Map<String, Object> serviceList = new HashMap<String, Object>();
        try{
            File file =new File(path);
            URL url = file.toURI().toURL();
            ClassLoader loader=new URLClassLoader(new URL[]{url});//创建类加载器
            for (String name: serviceClassNameList){
                Class<?> cls=loader.loadClass(name);//加载指定类，注意一定要带上类的包名
                Method[] methods = cls.getMethods();
                //Object obj=cls.newInstance();//初始化一个实例
                JavaToWS.main(new String[] { "-d", path.toString(), "-cp", path.toString(),"-o", name+".wsdl","-servicename",name,"-address","http://"+ip+"/services/"+name ,"-wsdl", name });
                serviceList.put(name,cls);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return serviceList;
    }

    public  String getCurrentPath(){
        //取得根目录路径
        String rootPath=getClass().getResource("/").getFile().toString();
        System.out.println(rootPath);
        //当前目录路径
        String currentPath1=getClass().getResource(".").getFile().toString();
        System.out.println(currentPath1);
        String currentPath2=getClass().getResource("").getFile().toString();
        System.out.println(currentPath2);
        //当前目录的上级目录路径
        String parentPath=getClass().getResource("../").getFile().toString();
        System.out.println(parentPath);

        return rootPath;

    }


    public static void main(String[] args){
        List<String> classNameList = new ArrayList<String>();
        classNameList.add("TestAction");
        classNameList.add("TestMain");
        Map<String, Object> serviceMap = new ClassLoaderUtil().getServiceList("E:\\test", null,classNameList);

        System.out.println(serviceMap.toString());
        String rootPath=new ClassLoaderUtil().getCurrentPath();
        String path = rootPath.substring(1,rootPath.length()-8).replaceAll("/","\\\\");
        System.out.println(path);
        StringBuilder pojoPath = new StringBuilder();
        pojoPath.append(path).append("\\\\pojo");
        System.out.println(pojoPath.toString());

        try {
            JavaToWS.main(new String[] { "-d", pojoPath.toString(), "-cp", pojoPath.toString(),"-o", "TestAction.wsdl","-servicename","TestAction","-address","http://10.33.45.32/services/TestAction" ,"-wsdl",
                    "TestAction" });
            System.out.println("finished %%%%%%%%%%");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
