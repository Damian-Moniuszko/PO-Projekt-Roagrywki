
public class Main {
    public static void main(String[] args){
      SezonPilkarski s1 = new SezonPilkarski("essa1");
      Klub k1 = new Klub(1, "Jacek Fc");
      Klub k2 = new Klub(2, "Jaga");
      s1.zarejestrujKlub(k1);
      s1.zarejestrujKlub(k2);
      //s1.generujTabele();
      Spotkanie sp1 = new Spotkanie(k1, k2);
      sp1.wprowadzWynik(1, 3);
      sp1.pobierzZwyciezce();
      s1.generujTabele();

    }
    
}
