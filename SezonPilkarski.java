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

    }

    public void generujTabele(){
        System.out.println("Klub | pkt");
        for(Klub kluby : listaKlubow){
            System.out.println(kluby.pobierzNazwe() + " | " + kluby.pobierzPunkty());
        }
    }

    public void zapiszStanSezonu(String sciezka){

    }

    public void wczytajStanSezonu(String sciezka){
        
    }
}
