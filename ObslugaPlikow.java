import java.io.*;

public class ObslugaPlikow {
    public static void zapiszStan(SezonPilkarski sezon, String sciezka) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(sciezka))) {
            oos.writeObject(sezon);
            System.out.println("Pomyślnie zapisano stan sezonu do pliku: " + sciezka);
        } catch (IOException e) {
            System.out.println("BŁĄD PODCZAS ZAPISU");
        }
    }

    public static SezonPilkarski wczytajStan(String sciezka) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sciezka))) {
            SezonPilkarski wczytany = (SezonPilkarski) ois.readObject();
            System.out.println("Pomyślnie wczytano stan sezonu z pliku: " + sciezka);
            return wczytany;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("BŁĄD PODCZAS ODCZYTU");
            return null;
        }
    }
}
