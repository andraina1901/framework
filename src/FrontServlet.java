package ETU1901.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

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
        PrintWriter out = resp.getWriter();
        out.print(url);
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
