package execution;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Vector;

// import annotation.Method;
import annotation.Model;
import model.Emp;
import xml.Config;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{
        Main.getAnnotationName("model");
        // Config.readXML("L:/ITU_L2/S4/Web Dynamique-Mr Naina/annotation/monFichier.xml","Jeremia");
    }

    public static ArrayList<Class> getAllAnnotedClass(String pckg) throws Exception{
        ArrayList<Class> allClass = new ArrayList<>();
        File f = new File(pckg);
        File[] lf = f.listFiles();
        String[] nomFile = null;
        for (int i = 0; i < lf.length; i++) {
            nomFile = lf[i].getName().split("\\.");
            Class c = Class.forName(pckg+"."+nomFile[0]);
            System.out.println(c.getAnnotations().length);
            if (c.isAnnotation()) {
                allClass.add(c);
            }
        }
        return allClass;
    }

    public static ArrayList<Field> getAnnotedField(String classe)throws Exception{
        ArrayList<Field> lf = new ArrayList<>();
        Class c = Class.forName(classe);
        Field[] f = c.getDeclaredFields();
        for (int i = 0; i < f.length; i++) {
            if (f[i].getAnnotations().length!=0) {
                lf.add(f[i]);
            }
        }
        return lf;
    }
    public static ArrayList<Method> getAnnotedMethod(String classe)throws Exception{
        ArrayList<Method> lf = new ArrayList<>();
        Class c = Class.forName(classe);
        Method[] f = c.getDeclaredMethods();
        for (int i = 0; i < f.length; i++) {
            if (f[i].getAnnotations().length!=0) {
                lf.add(f[i]);
            }
        }
        return lf;
    }

    public static void getAnnotationName(String pck)throws Exception{
        ArrayList<Class> lc = Main.getAllAnnotedClass(pck);
        System.out.println(lc.size());
        for (int i = 0; i < lc.size(); i++) {
            Model model = (Model) lc.get(i).getAnnotation(Model.class);
            System.out.println(model.getNameModel());
        }
    }
    
}
