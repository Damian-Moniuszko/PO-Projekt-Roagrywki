public class Klub {
    private int idKlub;
    private String nazwaKlub;
    private int rozegraneMecze;
    private int punkty;
    private int bramkiStrzelone;
    private int bramkiStracone;

    public Klub(int idKlub, String nazwaKlub){
        this.idKlub = idKlub;
        this.nazwaKlub = nazwaKlub;
    }
    public void aktualizujStatystyki(int strzelone, int stracone, int zdobytePunkty){
        this.bramkiStrzelone = strzelone;
        this.bramkiStracone = stracone;
        this.punkty = zdobytePunkty;
    }

    //public int pobierzinformacje(){
        
    //}

    public String pobierzNazwe(){
        return nazwaKlub;
    }
    public int pobierzPunkty(){
        return punkty;
    }
}
