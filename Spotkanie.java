import java.util.*;
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
    public Klub pobierzZwyciezcePuchar(){
        if(czyRozegrane==false){
            System.out.println("Mecz nie został rozegrany");
            return null;
        }
        else{
            if(wynik.pobierzGoleGospodarz()> wynik.pobierzGoleGosc()){
                gospodarz.aktualizujStatystyki(wynik.pobierzGoleGospodarz(), wynik.pobierzGoleGosc(), 3);
                gosc.aktualizujStatystyki(wynik.pobierzGoleGosc(), wynik.pobierzGoleGospodarz(), 0);
                return gospodarz;
            }
            if(wynik.pobierzGoleGospodarz()<wynik.pobierzGoleGosc()){
                gospodarz.aktualizujStatystyki(wynik.pobierzGoleGospodarz(), wynik.pobierzGoleGosc(), 0);
                gosc.aktualizujStatystyki(wynik.pobierzGoleGosc(), wynik.pobierzGoleGospodarz(), 3);
                return gosc;
            }
            else{
                Scanner sc = new Scanner(System.in);
                System.out.println("REMIS! RZUTY KARNE!");
                System.out.println("Ilość strzelonych karnych dla gospodarza: ");
                int gospK = sc.nextInt();
                System.out.println("Ilość strzelonych karnych dla gościa: ");
                int goscK = sc.nextInt();
                if(gospK>goscK){
                    gospodarz.aktualizujStatystyki(wynik.pobierzGoleGospodarz(), wynik.pobierzGoleGosc(), 3);
                    gosc.aktualizujStatystyki(wynik.pobierzGoleGosc(), wynik.pobierzGoleGospodarz(), 0);
                    return gospodarz;
                }
                else{
                    gospodarz.aktualizujStatystyki(wynik.pobierzGoleGospodarz(), wynik.pobierzGoleGosc(), 0);
                    gosc.aktualizujStatystyki(wynik.pobierzGoleGosc(), wynik.pobierzGoleGospodarz(), 3);
                    return gosc;
                }
            }
        }
    }
    public void wypiszInformacje(){
        System.out.println("===MECZ===");
        System.out.println(gospodarz.pobierzNazwe()+" vs "+gosc.pobierzNazwe());
    }
}
