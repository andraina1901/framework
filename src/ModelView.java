package etu1901;

import java.util.HashMap;

public class ModelView {
    String chemin;
    HashMap<String,Object> data;
    boolean isJson;

    public ModelView(String c){
        chemin = c;
        data = new HashMap<String,Object>();
    }
    
    public ModelView(){
        data = new HashMap<String,Object>();
    }

    public String getChemin(){
        return chemin;
    }

    public void setChemin(String str){
        chemin = str;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public void addItem(String key, Object value){
        
        this.data.put(key, value);
    }

    public boolean isJson() {
        return isJson;
    }

    public void setJson(boolean isJson) {
        this.isJson = isJson;
    }
    
}
