import java.util.*;

public abstract class SezonPilkarski implements java.io.Serializable {
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

    public abstract void generujTerminarzSezonu() throws GenerujTerminarzException;
    
    public void wpiszWyniki(int nrKolejki) throws Exception{
        Scanner sc = new Scanner(System.in); // nowy czytnik
        KolejkaLigowa k = terminarz.get(nrKolejki-1); //wyciagniecie kolejki o nr - 1, do wpisania wynikow
        if(k.czyWszystkieMeczeZakonczone()==true){
                throw new WpiszWynikiException("BŁĄD, TA KOLEJKA ZOSTAŁA JUŻ ROZEGRANA!"); //blad
                }
        for(Spotkanie sp : k.pobierzSpotkanie()){ //petla ktora przechodzi po wszyskich spotkaniach w kolejce
            try{ 
                int gosp,gosc;
                sp.wypiszInformacje();
                System.out.println("Podaj wynik dla gospodarza: "); //wprowadzenie wyniku dla gospodarza
                gosp = sc.nextInt();
                if(gosp<0){throw new WpiszWynikiException("BŁĄD, WYNIK NIE MOŻE BYĆ NA MINUSIE!");}
                System.out.println("Podaj wynik dla goscia: "); //wprowadzenie wyniku dla goscia
                gosc = sc.nextInt();
                if(gosc<0){throw new WpiszWynikiException("BŁĄD, WYNIK NIE MOŻE BYĆ NA MINUSIE!");}
                sp.wprowadzWynik(gosp, gosc); //wpisanie wynikow
                sp.pobierzZwyciezce(); //dopisanie goli i pkt do klubow
            }    
            catch(IllegalStateException e){
                System.out.println(e);
            }
        }
        k.zakonczKolejke();//zakonczenie kolejki
    }

    public abstract void generujTabele() throws GenerujTabeleException;

    public void zapiszStanSezonu(String sciezka){

    }

    public void wczytajStanSezonu(String sciezka){
        
    }
}
