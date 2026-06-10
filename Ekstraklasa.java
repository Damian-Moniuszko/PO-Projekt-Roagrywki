import java.util.ArrayList;
import java.util.List;

public class Ekstraklasa extends SezonPilkarski{
    public Ekstraklasa(String nazwaSezonu){
        super(nazwaSezonu);
    }
    @Override
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

    @Override
    public void generujTabele(){
        boolean informator;
        System.out.println("+-------------------------+-------+");
        System.out.printf("| %-23s | %-5s |\n", "Klub", "pkt");
        System.out.println("+-------------------------+-------+");
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
                System.out.printf("| %-23s | %5s |\n", kluby.pobierzNazwe(), String.valueOf(kluby.pobierzPunkty())); // wypisanie tabeli
            }
        System.out.println("+-------------------------+-------+");
    }
}
