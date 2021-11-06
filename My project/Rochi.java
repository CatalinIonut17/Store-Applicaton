public class Rochi extends Produse{
    
    Rochi(){
    
    }
    
    Rochi(double pret, String culoare){
        super(pret, culoare);
    
    }
    
    @Override
    public String toString(){
        return "Rochia are pretul " + pret + " lei si culoarea " + culoare;
    
    }
}