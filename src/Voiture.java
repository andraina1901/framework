package koursa;
import annote.Url;
import etu1901.ModelView;
import annote.Scope;

@Scope("singleton")
public class Voiture {
    int numero;
    String nom;

    public Voiture(){

    }

    public void findById(){
        
    }

    @Url("maka")
    public ModelView findAll(){
        ModelView mv = new ModelView("view.jsp");
        mv.addItem("nom", this.nom);
        return mv;
    }

    @Url("good")
    public String save(){
        return "save";
    }


    @Url("test-singleton")
    public ModelView test(){
        return new ModelView("single.jsp");
    }

    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNumero(String numero) {
        this.numero = Integer.valueOf(numero);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
