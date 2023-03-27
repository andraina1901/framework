package objet;

import java.lang.reflect.Method;

import ETU1901.framework.Mapping;

public class Utilitaire {
    
    public static String getParameter(String url){
        url = url.substring(1, url.length());
        String[] rep = url.split("/");
        return rep[0];
    }

    public static Object apply(Mapping m)throws Exception{
        Class c = Class.forName(m.getClassName());
        Object toreturn = c.newInstance();
        Method mt = toreturn.getClass().getDeclaredMethod(m.getMethod(), null);
        return mt.invoke(toreturn);
    }
}
