
public class Main {
    public static void main(String[] args){
      SezonPilkarski s1 = new SezonPilkarski("essa1");
      Klub k1 = new Klub(1, "Jacek Fc");
      Klub k2 = new Klub(2, "Jaga");
      Klub k3 = new Klub(3,"Borowiki CF");
      Klub k4 = new Klub (4,"Legia");
      s1.zarejestrujKlub(k1);
      s1.zarejestrujKlub(k2);
      s1.zarejestrujKlub(k3);
      s1.zarejestrujKlub(k4);
      s1.generujTabele();
      s1.generujTerminarzSezonu();
      s1.wpiszWyniki(1);
      s1.generujTabele();
      s1.wpiszWyniki(2);
      s1.generujTabele();
      s1.wpiszWyniki(3);
      s1.generujTabele();
      

    }
    
}
