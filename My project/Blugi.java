public class Blugi extends Produse{
    
    boolean buzunare;
    
    Blugi(){
    
    }
    
    Blugi(double pret, String culoare, boolean buzunare){
        super(pret, culoare);
        this.buzunare = buzunare;
    }
    
    @Override 
    public String toString(){
        if(this.buzunare == true){
            return "Blugi au pretul " + pret + " lei, culoarea " + culoare + " si au buzunar.";
        }else{
            return "Blugi au pretul " + pret + " lei, culoarea " + culoare + " si nu au buzunar.";
        }
    }
}