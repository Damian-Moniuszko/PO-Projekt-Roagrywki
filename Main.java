public class Main {
    public static void main(String[] args){

        // Utowrzenie Sezonu oraz Klubow + dodanie ich do sezonu
        SezonPilkarski s1 = new SezonPilkarski("Ekstraklasa 2025/2026");
        Klub k1 = new Klub(1, "Jagiellonia Białystok");
        Klub k2 = new Klub(2, "Legia Warszawa");
        Klub k3 = new Klub(3,"Lech Poznań");
        Klub k4 = new Klub (4,"Górnik Zabrze");
        s1.zarejestrujKlub(k1);
        s1.zarejestrujKlub(k2);
        s1.zarejestrujKlub(k3);
        s1.zarejestrujKlub(k4);
        s1.generujTabele();
        s1.generujTerminarzSezonu();
        // s1.wpiszWyniki(1);
        // s1.generujTabele();
        // s1.wpiszWyniki(2);
        // s1.generujTabele();
        // s1.wpiszWyniki(3);
        // s1.generujTabele();
      

    }
}
