package objet;

public class Utilitaire {
    
    public static String getParameter(String url){
        url = url.substring(1, url.length());
        String[] rep = url.split("/");
        return rep[0];
    }
}
