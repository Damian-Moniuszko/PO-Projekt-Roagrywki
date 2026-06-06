import java.util.*;;

public class KolejkaLigowa {
    private int numerKolejki;
    private List<Spotkanie> meczeWKolejce;
    private boolean czyZakonczona;
    
    public KolejkaLigowa(int numer){
        this.numerKolejki = numer;
        this.meczeWKolejce = new ArrayList<>();
        this.czyZakonczona = false;
    }
    public void dodajMecz(Spotkanie s){
        meczeWKolejce.add(s);
    }
    public List<Spotkanie> pobierzSpotkanie(){
        return meczeWKolejce;
    }
    public int pobierzNumerKolejki(){
        return numerKolejki;
    }
    public void zakonczKolejke(){
        czyZakonczona = true;
    }
    public boolean czyWszystkieMeczeZakonczone(){
        return czyZakonczona;
    }
}
