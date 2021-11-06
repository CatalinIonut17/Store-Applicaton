import java.util.*;

public class Magazin implements MagazinInterface{
    private static Magazin SINGLETON;
    //int [] cabinaProba = new int [3];
    // int nrProduse; 
    //boolean ocupata;
    //int nrCabina;
    Clienti cl = new Clienti();
    ArrayList<Clienti> nrClienti = new ArrayList<>();
    ArrayList<Produse> stoc = new ArrayList<>();
    Cabina cb = new Cabina();
    
    private Magazin(){}

    public static final Magazin getInstance(){
        if(SINGLETON == null){
            SINGLETON = new Magazin();
        }
        return SINGLETON;
    }

    /*public void cabinaOcupata(){   // => am vrut sa vad daca se ocupa sau nu cabina.
    for(int x : cabinaProba){
    if(x == 0 ){
    ocupata = false;
    System.out.println(ocupata);
    }
    else{
    ocupata  = true; 
    System.out.println(ocupata);
    }
    }
    }*/

    @Override 
    public void folosesteCabina(int nrCabina ){
        if( cb.cabinaProba[nrCabina - 1]  == 0){
            if(cl.listaProduse.size() <= 3){
                System.out.println("Va rog sa ocupati cabina numarul " + (nrCabina ));
                cb.cabinaProba[nrCabina - 1] = 1;
            }else{
                try{
                    throw new PreaMulteProduse();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        }else{
            System.out.println("Cabina numarul " + (nrCabina ) + "  este ocuapata.");
        }

    }
    
    public void folosesteCabina(int nrCabina , String nume, String prenume){ // metoda care verifica si clientul 
        for(Clienti cl : nrClienti){
            if(nume.equals(cl.getNume()) && prenume.equals(cl.getPrenume())){
        
                if( cb.cabinaProba[nrCabina - 1]  == 0){
                    if(cl.listaProduse.size() <= 3){
                        System.out.println("Va rog sa ocupati cabina numarul " + (nrCabina ));
                        cb.cabinaProba[nrCabina - 1] = 1;
                    }else{
                        try{
                            throw new PreaMulteProduse();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }

                }else{
                    System.out.println("Cabina numarul " + (nrCabina ) + "  este ocuapata.");
                }
            }else{
                System.out.println("Clientul nu se afla in magazin.");
            }
        }
    }
    
    /*@Override
    public void folosesteCabina(int nrProduse){ // =>metoda care utilizeaza numarul de produse
        if(nrProduse <= 3 ){
            if(cabinaProba[0] == 0){
                System.out.println("Va rog sa ocupati cabina numarul 1.");
                cabinaProba[0] = 1;
            }else{
                if(cabinaProba[1] == 0){
                    System.out.println("Va rog sa ocupati cabina numarul 2.");
                    cabinaProba[1] = 1;
                }else{
                    if(cabinaProba[2] == 0){
                        System.out.println("Va rog sa ocupati cabina numarul 3.");
                        cabinaProba[2] = 1;
                    }else{
                        System.out.println("Toate cabinele sunt ocupate. Va rog sa asteptati");
                    }
                }
            }
        }else{
            try{
                throw new PreaMulteProduse();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }*/

    @Override
    public void elibereazaCabina(int nrCabina){
        if(cb.cabinaProba[nrCabina - 1] == 1){ // am pus cabinaProba[nrCabina - 1] pentru ca atunci cand apelam metoda sa citeasca cabine de la 1 la 3
            cb.cabinaProba[nrCabina - 1] = 0 ; 
            System.out.println("Cabina numarul " + (nrCabina) + " a fost eliberata.");
        }else{
            System.out.println("Cabina numarul " + + (nrCabina) + " este libera");
        }
    }

    @Override
    public void adaugaCumparator(String nume, String prenume, boolean cardReducere){
        if(nrClienti.size() < 99){ //am pus doar mai mic deaorece noi avem conditia de 100 de clienti, dar in array numaratoarea incepe de la 0 si se termina la n-1
            Clienti c = new Clienti();
            c.setNume(nume);
            c.setPrenume(prenume);
            c.setCardReducere(cardReducere);
            nrClienti.add(c);
            System.out.println("S-a adaugat clientul " + nume + " " + prenume + ". " + c.toString() );

        }else{
            try{
                throw new PreaMultiClienti();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override 
    public void afiseazaCumparator(){
        for(int c=0 ; c < nrClienti.size(); c++){
            System.out.println(nrClienti.get(c).toString());
        }
    }

    public void adaugaProdusInStoc(Produse p){
        if(p instanceof Rochi){
            Rochi r = (Rochi) p;
            stoc.add(r);
            System.out.println("In stoc a fost adaugat un produs de tipul rochie.");
        }else{
            if(p instanceof Blugi){
                Blugi b = (Blugi) p;
                stoc.add(b);
                System.out.println("In stoc a fost adaugat un prdus de tipul blugi.");
            }else{
                Tricouri t = (Tricouri) p;
                stoc.add(t);
                System.out.println("In stoc a fost adaugat un produs de tipul tricou.");
            }
        }

    }

    @Override
    public void afiseazaProduse(){
        for(int p = 0; p<stoc.size(); p++){
            System.out.println(stoc.get(p).toString());
        }
    }

    public void afiseazaTricouri(){
        for(int t = 0; t<stoc.size(); t++){
            if(stoc.get(t) instanceof Tricouri){
                System.out.println(stoc.get(t).toString());
            }
        }
    }

    public void afiseazaRochi(){
        for(int r = 0; r<stoc.size(); r++){
            if(stoc.get(r) instanceof Rochi){
                System.out.println(stoc.get(r).toString());
            }
        }
    }

    public void afiseazaBlugi(){
        for(int b = 0; b<cl.listaProduse.size(); b++){
            if(stoc.get(b) instanceof Blugi){
                System.out.println(stoc.get(b).toString());
            }
        }
    }

    @Override 
    public void adaugaProdusePentruCumparator(Produse p, String nume, String prenume){
        boolean  existaClient = false;

        for(Clienti cl : nrClienti){
            if(nume.equals(cl.getNume()) && prenume.equals(cl.getPrenume())){
                if(p instanceof Rochi){
                    Rochi r = (Rochi) p;
                    cl.listaProduse.add(r);
                    System.out.println("Pentru cumparatorul " + nume + " " + prenume + " a fost adaugata o rochie");
                    
                }else{
                    if(p instanceof Blugi){
                        Blugi b = (Blugi) p;
                        cl.listaProduse.add(b);
                        System.out.println("Pentru cumparatorul " + nume + " " + prenume + " a fost adaugata o pereche de blugi.");
                        
                    }else{
                        Tricouri t = (Tricouri) p;
                        cl.listaProduse.add(t);
                        System.out.println("Pentru cumparatorul " + nume + " " + prenume + " a fost adaugata tricou.");
                        
                    }
                }
                existaClient = true;
                break;
            }
        }
        if(!existaClient){
            System.out.println("Clientul nu este in magazin");
        }
    }

    public void afiseazaProduseClient(String nume, String prenume){

        for(Clienti cl : nrClienti){
            if(nume.equals(cl.getNume()) && prenume.equals(cl.getPrenume())){
                System.out.println("Clientul " + nume + " " + prenume + " are produsele: " +
                    cl.listaProduse.toString());

            }
        } 
    }

    public void vizualizeazaSuma(String nume, String prenume ){
        double suma = 0.0;
        boolean existaClient = false;
        
        for(Clienti cl : nrClienti){
            if(nume.equals(cl.getNume()) && prenume.equals(cl.getPrenume())){
                for(Produse p : cl.listaProduse){
                    suma = suma + p.pret;
                }
                existaClient = true;
                break;
            }
        }
        if(!existaClient){
            System.out.println("Clientul nu se afla in magazin");
        }else{
            System.out.println("Clientul " + nume + " " + prenume + 
                " are in cos produse in valoare de " + suma);
        }
    }

}
