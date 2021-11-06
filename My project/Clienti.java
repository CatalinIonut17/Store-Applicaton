import java.util.*;

public class Clienti{
    
     private String nume;
     private String prenume;
     private boolean cardReducere;
     ArrayList<Produse> listaProduse =new ArrayList<>();
     double reducere;
    
   
    
    Clienti(){}
   
    /*Clienti(String nume, String prenume, boolean cardReducere){
       this.nume = nume;
       this.prenume = prenume;
       this.cardReducere = cardReducere;
    }*/
    
    public String getNume(){
        return this.nume;
    }
    
    public void setNume(String nume){
        this.nume = nume;
    }
    
    public String getPrenume(){
        return this.prenume;
    }
    
    public void setPrenume(String prenume){
        this.prenume = prenume; 
    }
    
    public boolean isCardReducere(){
        return this.cardReducere;
    }
    
    public void setCardReducere(boolean cardReducere){
        this.cardReducere = cardReducere;
    }
    
    public double reducere(Tricouri t){// sau as putea sa o pun ca un atribut si sa fac cu if in acolade
        
        if(cardReducere == true){
            this.reducere = 0.15 * t.pret;
        }else{
            this.reducere = t.pret;
        }
        
        return reducere;
    }
    
    @Override
    public String toString(){
        if(this.cardReducere == true){
            return "Clientul " + nume + " " + prenume + " , are card de reducere";
        }else{
            return "Clientul " + nume + " " + prenume + " , nu are card de reducere";
        }
    }
}