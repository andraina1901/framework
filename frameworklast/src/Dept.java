package model;
import annotation.*;

public class Dept {
    int numerodept;
    String name;
    
    @Url("dept-getNom")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Url("dept-getNum")
    public int getNumerodept() {
        return numerodept;
    }
    public void setNumerodept(int numerodept) {
        this.numerodept = numerodept;
    }
}
