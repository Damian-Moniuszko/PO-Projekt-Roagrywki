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
        this.bramkiStrzelone += strzelone;
        this.bramkiStracone += stracone;
        this.punkty += zdobytePunkty;
    }

    public void pobierzinformacje(){
        System.out.println("===INFORMACJE O KLUBIE===");
        System.out.println(nazwaKlub);
        System.out.println("Rozegrane mecze: "+rozegraneMecze);
        System.out.println("Bramki strzelone: "+bramkiStrzelone);
        System.out.println("Bramki stracone: "+bramkiStracone);
    }

    public String pobierzNazwe(){
        return nazwaKlub;
    }
    public int pobierzPunkty(){
        return punkty;
    }
}
