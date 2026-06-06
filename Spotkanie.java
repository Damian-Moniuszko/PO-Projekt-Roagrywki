public class Spotkanie {
    private Klub gospodarz;
    private Klub gosc;
    private WynikMeczu wynik;
    private boolean czyRozegrane = false;

    public Spotkanie(Klub gosp, Klub gosc){
        this.gospodarz = gosp;
        this.gosc = gosc;
    }
    public void wprowadzWynik(int goleGospodarz, int goleGosc){
        this.wynik = new WynikMeczu(goleGospodarz, goleGosc);
        this.czyRozegrane = true;
    }

    public void pobierzZwyciezce(){
        if(czyRozegrane==false){
            System.out.println("Mecz nie został rozegrany");
        }
        else{
            if(wynik.pobierzGoleGospodarz()> wynik.pobierzGoleGosc()){
                gospodarz.aktualizujStatystyki(wynik.pobierzGoleGospodarz(), wynik.pobierzGoleGosc(), 3);
                gosc.aktualizujStatystyki(wynik.pobierzGoleGosc(), wynik.pobierzGoleGospodarz(), 0);
                System.out.println("WYGRYWA: "+gospodarz.pobierzNazwe());
            }
            if(wynik.pobierzGoleGospodarz() == wynik.pobierzGoleGosc()){
                gospodarz.aktualizujStatystyki(wynik.pobierzGoleGospodarz(), wynik.pobierzGoleGosc(), 1);
                gosc.aktualizujStatystyki(wynik.pobierzGoleGosc(), wynik.pobierzGoleGospodarz(), 1);
                System.out.println("REMIS");
            }
            if(wynik.pobierzGoleGospodarz()<wynik.pobierzGoleGosc()){
                gospodarz.aktualizujStatystyki(wynik.pobierzGoleGospodarz(), wynik.pobierzGoleGosc(), 0);
                gosc.aktualizujStatystyki(wynik.pobierzGoleGosc(), wynik.pobierzGoleGospodarz(), 3);
                System.out.println(gosc.pobierzNazwe());
            }
        }
        

    }
    public void wypiszInformacje(){
        System.out.println("===MECZ===");
        System.out.println(gospodarz.pobierzNazwe()+" vs "+gosc.pobierzNazwe());
    }
}
