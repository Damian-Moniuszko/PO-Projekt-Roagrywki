import java.util.*;;

public class KolejkaLigowa {
    private int numerKolejki;
    private List<Spotkanie> meczeWKolejce;
    
    public KolejkaLigowa(int numer){
        this.numerKolejki = numer;
        this.meczeWKolejce = new ArrayList<>();
    }
    public void dodajMecz(Spotkanie s){
        meczeWKolejce.add(s);
    }

    // public boolean czyWszystkieMeczeZakonczone(){
        
    // }
}
