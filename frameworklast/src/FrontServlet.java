package ETU1901.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Vector;

import ETU1901.framework.Mapping;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import objet.Utilitaire;

public class FrontServlet extends HttpServlet {

    HashMap<String,Mapping> MappingUrls;

    public void ProcessRequest(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String url = req.getServletPath();
        String r =Utilitaire.getParameter(url);
        PrintWriter out = resp.getWriter();
        for (String key : MappingUrls.keySet()) {
            if (key.equals(r)) {
                out.print(MappingUrls.get(key).getMethod()+"  "+MappingUrls.get(key).getClassName()+"   "+key+"\n");
            }
        }
    }

    public void init(){
        String pckg = getInitParameter("path");
        ArrayList<Class> allClass = new ArrayList<>();
        File f = new File(pckg);
        File[] lf = f.listFiles();
        String[] nomFile = null;
        try {
            for (int i = 0; i < lf.length; i++) {
                nomFile = lf[i].getName().split("\\.");
                Class c = Class.forName("model"+"."+nomFile[0]);
                allClass.add(c);
            } 
            Class annotMethod = Class.forName("annotation.Url");
            MappingUrls = new HashMap<String,Mapping>();
            for (int i = 0; i < allClass.size(); i++) {
                Method[] m = allClass.get(i).getDeclaredMethods();
                for (int j = 0; j < m.length; j++) {
                    if (m[j].isAnnotationPresent(annotMethod)) {
                        Method rep = m[j].getAnnotations()[0].annotationType().getDeclaredMethod("value",null);
                        String key = rep.invoke(m[j].getAnnotations()[0]).toString();
                        Mapping h = new Mapping(allClass.get(i).getName(),m[j].getName());
                        MappingUrls.put(key,h);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.ProcessRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.ProcessRequest(req, resp);
    }

    public HashMap<String, Mapping> getMappingUrls() {
        return MappingUrls;
    }

    public void setMappingUrls(HashMap<String, Mapping> mappingUrls) {
        MappingUrls = mappingUrls;
    }
    
}
