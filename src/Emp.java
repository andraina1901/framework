package model;
import annotation.*;

public class Emp {
    int numero;
    String name;
    @Url("emp-getNum")
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    @Url("emp-getNom")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
