import java.util.*;

public class Principal /*extends TimerTask*/ {
    public static void main(String [] args){
        //long sT = System.currentTimeMillis();
        
        Magazin magazin = Magazin.getInstance();
        Timo tm = new Timo();
        Scanner sc = new Scanner(System.in);  
        //Timer timer = new Timer();
        //timer.schedule(new Principal(), 0 , 5000);
        
        while(true){
            System.out.println(tm);
            System.out.println("Va rog sa introduceri o comanda conform cu lista de mai jos si in functie de parametrii");
            System.out.println();
            System.out.println("Exit                => inchide programul");
            System.out.println("AdaugaCumparator    => Nume Client, Prenume Client, Card Reducere (true/false)");
            System.out.println("AfiseazaCumparatori => Nu are parametrii");
            System.out.println("AfiseazaProduse     => Nume Client, Prenume Client");
            System.out.println("AdaugaProdus        => TipProdus(Blugi/ Rochie/ Tricou), Pret, Culoare , buzunare(true/false)");
            System.out.println("                      " + " pentru Blugi, Nume Client, Prenume Client" );
            System.out.println("VizualizareSuma     => Nume Client, Prenume Client");
            System.out.println("AfiseazaBlugi       => Nu are parametrii ");
            System.out.println("AfiseazaRochi       => Nu are parametrii ");
            System.out.println("AfiseazaTricouri    => Nu are parametrii");
            System.out.println("FolosesteCabina X   => Numarul Cabinei");
            System.out.println("ElibereazaCabina X  => Numarul Cabinei");
            System.out.println("AdaugaProdusStoc    => TipProdus(Blugi/ Rochie/ Tricou), Pret, Culoare , buzunare(true/false) pentru Blugi");
            String s = sc.nextLine();
            String [] intr = s.split(" ");
           
            switch(intr[0]){
                case "Exit":
                    System.out.println("Aplicatia se v-a inchide in cateva secunde");
                    System.exit(200);
                break;
                case "AdaugaCumparator":
                    String nume = intr[1];
                    String prenume = intr[2];
                    boolean cardReducere =Boolean.parseBoolean(intr[3]);
                    magazin.adaugaCumparator(nume, prenume, cardReducere);
                    System.out.println();

                break;
                case "AfiseazaCumparatori":
                    magazin.afiseazaCumparator();
                    System.out.println();
                    
                break;
                case "AfiseazaProduse":
                    String numeAP = intr[1];
                    String prenumeAP = intr[2];
                    magazin.afiseazaProduseClient(numeAP, prenumeAP);
                    System.out.println();

                break;
                case "AdaugaProdus":
                    if(intr[1].equals("Blugi")){
                        double pret = Double.parseDouble(intr[2]);
                        String culoare = intr[3];
                        boolean buzunare = Boolean.parseBoolean(intr[4]);
                        String numeAdP = intr[5];
                        String prenumeAdP = intr[6]; 
                        Blugi bl = new Blugi(pret, culoare, buzunare);
                        
                        magazin.adaugaProdusePentruCumparator(bl, numeAdP, prenumeAdP);
                    }
                    if(intr[1].equals("Rochie")){
                        double pret = Double.parseDouble(intr[2]);
                        String culoare = intr[3];
                        String numeAdP = intr[4];
                        String prenumeAdP = intr[5]; 
                        Rochi r = new Rochi(pret, culoare);
                        
                        magazin.adaugaProdusePentruCumparator(r, numeAdP, prenumeAdP);
                    }
                    if(intr[1].equals("Tricou")){
                        double pret = Double.parseDouble(intr[2]);
                        String culoare = intr[3];
                        String numeAdP = intr[4];
                        String prenumeAdP = intr[5]; 
                        Tricouri t = new Tricouri(pret, culoare);
                        
                        magazin.adaugaProdusePentruCumparator(t, numeAdP, prenumeAdP);
                    }
                    System.out.println();
                    
                break;
                case "VizualizareSuma":
                    String numeVS = intr[1];
                    String prenumeVS = intr[2];
                    magazin.vizualizeazaSuma(numeVS, prenumeVS);
                    System.out.println();
                    
                break;
                case "AfiseazaBlugi":
                    magazin.afiseazaBlugi();
                    System.out.println();
                    
                break;
                
                case "AfiseazaTricouri":
                    magazin.afiseazaTricouri();
                    System.out.println();
                    
                break;
                
                case "AfiseazaRochi":
                    magazin.afiseazaRochi();
                    System.out.println();
                    
                break;
                
                case "FolosesteCabina":
                    int nrCabina = Integer.parseInt(intr[1]);
                    String numeFC = intr[2];
                    String prenumeFC = intr[3];
                    magazin.folosesteCabina(nrCabina, numeFC, prenumeFC );
                    System.out.println();
                    
                break;
                
                case "ElibereazaCabina":
                    int nrCab = Integer.parseInt(intr[1]);
                    magazin.elibereazaCabina(nrCab);
                    System.out.println();
                    
                break;
                case "AdaugaProdusStoc":
                    if(intr[1].equals("Blugi")){
                        double pret = Double.parseDouble(intr[2]);
                        String culoare = intr[3];
                        boolean buzunare = Boolean.parseBoolean(intr[4]);
                        Blugi bl = new Blugi(pret, culoare, buzunare);
                        
                        magazin.adaugaProdusInStoc(bl);
                    }
                    if(intr[1].equals("Rochie")){
                        double pret = Double.parseDouble(intr[2]);
                        String culoare = intr[3];
                        Rochi r = new Rochi(pret, culoare);
                        
                        magazin.adaugaProdusInStoc(r);
                    }
                    if(intr[1].equals("Tricou")){
                        double pret = Double.parseDouble(intr[2]);
                        String culoare = intr[3];
                        Tricouri t = new Tricouri(pret, culoare);
                        
                        magazin.adaugaProdusInStoc(t);
                    }
                    System.out.println();
                break;
            }
            //long endTime = System.currentTimeMillis();
            //long diferenta = endTime - startTime;
        }

    }
   
   
    
    /*@Override
    public void run(){
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Programul ruleaza de " + diferenta);
    }*/
       
}