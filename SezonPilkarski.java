import java.util.*;

public class SezonPilkarski {
    protected String nazwaSezonu;
    protected List<Klub> listaKlubow;
    protected List<KolejkaLigowa> terminarz;

    public SezonPilkarski(String nazwa){
        this.nazwaSezonu = nazwa;
        this.listaKlubow = new ArrayList<>();
        this.terminarz = new ArrayList<>();
    }
    public void zarejestrujKlub(Klub k){
        listaKlubow.add(k);
        System.out.println("DODANO KLUB: "+k.pobierzNazwe());
    }

    public void generujTerminarzSezonu(){
        List<Klub> listaZapasowa = new ArrayList<>(listaKlubow);
        int liczbaMeczow = listaZapasowa.size()/2;
        KolejkaLigowa k1 = new KolejkaLigowa(1);
        for(int i=0;i<liczbaMeczow;i++){
            Klub gosp = listaZapasowa.get(i);
            Klub gosc = listaZapasowa.get(listaZapasowa.size()-1-i);
            Spotkanie spotkanie = new Spotkanie(gosp, gosc);
            k1.dodajMecz(spotkanie);
        }
            
            
    }

    public void generujTabele(){
        boolean informator;
        System.out.println("Klub | pkt");
        //ponizej sortowanie tabeli po punktach, jezeli beda takie same warotsci dla pkt, to po nazwie
        do{
            informator=false;
            for(int i=0;i<listaKlubow.size()-1;i++){
            Klub pierwszy = listaKlubow.get(i);
            Klub drugi = listaKlubow.get(i+1);
            if(drugi.pobierzPunkty() > pierwszy.pobierzPunkty()){
                listaKlubow.set(i,drugi);
                listaKlubow.set(i+1,pierwszy);
                informator=true;
            }
            if(pierwszy.pobierzPunkty()==drugi.pobierzPunkty()){
                if(pierwszy.pobierzNazwe().compareTo(drugi.pobierzNazwe())>0){
                    listaKlubow.set(i,drugi);
                    listaKlubow.set(i+1,pierwszy);
                    informator=true;
                }
            }
            
            }
        }while(informator==true);
        for(Klub kluby:listaKlubow){
                System.out.println(kluby.pobierzNazwe()+" | "+kluby.pobierzPunkty()); // wypisanie tabeli
            }
        
        
    }

    public void zapiszStanSezonu(String sciezka){

    }

    public void wczytajStanSezonu(String sciezka){
        
    }
}
