package us;
import java.lang.reflect.*;
import java.lang.*;
import java.lang.annotation.Annotation;
import java.io.*;
import java.nio.file.*; 
import java.util.ArrayList;
import java.util.*;

import etu1901.FileUpload;
import etu1901.framework.*;
import annote.*;

public class TestAnnoter{
    public TestAnnoter(){}

    public static void run(Class cl, Class a, HashMap<String,Mapping> hash, Class a2, HashMap<Class,Object> sing) throws Exception{
        Method[] methods = cl.getMethods();
        String j = "";
        
        if (cl.isAnnotationPresent(a2)) {
            Method m = cl.getAnnotations()[0].annotationType().getDeclaredMethod("value",null);
            String me = m.invoke(cl.getAnnotations()[0]).toString();
            if(me.equalsIgnoreCase("singleton")){
                sing.put(cl, cl.newInstance());
            }
        }
        for(Method d : methods){
            if(d.isAnnotationPresent(a)){
                Method m = d.getAnnotations()[0].annotationType().getDeclaredMethod("value",null);
                j = m.invoke(d.getAnnotations()[0]).toString();
                System.out.println(j);
                hash.put(j, new Mapping(cl.getName(),d.getName())); 
            }
        }
    }

    public static Object take(String classe, String method) throws Exception{
        Class c = Class.forName(classe);
        Object o = c.newInstance();
        Method methods = o.getClass().getDeclaredMethod(method,null);
        Object valiny = methods.invoke(o);
        return valiny;
    }

}