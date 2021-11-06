public class Tricouri extends Produse{

    Tricouri(){

    }

    Tricouri(double pret, String culoare){
        super(pret, culoare);
    }

    @Override 
    public String toString(){
        return "Tricoul are pretul " + pret + " lei si culoarea " + culoare;
    }
}