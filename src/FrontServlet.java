package ETU1901.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import objet.Utilitaire;

public class FrontServlet extends HttpServlet {

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
    
}
