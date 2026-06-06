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
        int liczbaKolejek = listaZapasowa.size()-1;
        for(int i=0;i<liczbaKolejek;i++){
            KolejkaLigowa kolejka = new KolejkaLigowa(i);
            for(int j=0;j<liczbaMeczow;j++){
                Klub gosp = listaZapasowa.get(j);
                Klub gosc = listaZapasowa.get(listaZapasowa.size()-1-j);
                Spotkanie spotkanie = new Spotkanie(gosp, gosc);
                kolejka.dodajMecz(spotkanie);
            }
            terminarz.add(kolejka);
            Klub ostatni = listaZapasowa.remove(listaZapasowa.size()-1);
            listaZapasowa.add(1,ostatni);
        } 
            
    }
    public void wpiszWyniki(int nrKolejki) throws Exception{
        Scanner sc = new Scanner(System.in); // nowy czytnik
        KolejkaLigowa k = terminarz.get(nrKolejki-1); //wyciagniecie kolejki o nr - 1, do wpisania wynikow
        if(k.czyWszystkieMeczeZakonczone()==true){
                throw new IllegalStateException("BŁĄD, TA KOLEJKA ZOSTAŁA JUŻ ROZEGRANA!"); //blad
                }
        for(Spotkanie sp : k.pobierzSpotkanie()){ //petla ktora przechodzi po wszyskich spotkaniach w kolejce
            try{ 
                int gosp,gosc;
                sp.wypiszInformacje();
                System.out.println("Podaj wynik dla gospodarza: "); //wprowadzenie wyniku dla gospodarza
                gosp = sc.nextInt();
                System.out.println("Podaj wynik dla goscia: "); //wprowadzenie wyniku dla goscia
                gosc = sc.nextInt();
                sp.wprowadzWynik(gosp, gosc); //wpisanie wynikow
                sp.pobierzZwyciezce(); //dopisanie goli i pkt do klubow
            }    
            catch(IllegalStateException e){
                System.out.println(e);
            }
        }
        k.zakonczKolejke();//zakonczenie kolejki
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
