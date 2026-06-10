import java.util.Scanner;

public class Menu {
    private SezonPilkarski sezon;
    private Scanner scanner;
    private int nastepneIdKlubu = 1; 

    public Menu() {
        this.sezon = null;
        this.scanner = new Scanner(System.in);
    }

    public void wyswietl() {
        int wybor = -1;

        while (wybor != 0) {
            System.out.println("\n--- Menu ---");
            if (sezon == null) {
                System.out.println("Aktualny stan: BRAK AKTYWNEGO STANU");
            } else {
                String typRozgrywek = (sezon instanceof Ekstraklasa) ? "[LIGA]" : "[PUCHAR]";
                System.out.println("Aktualny sezon: " + sezon.nazwaSezonu + typRozgrywek);
            }
            System.out.println("1. Stwórz nowy sezon");
            System.out.println("2. Zarejestruj nowy klub");
            System.out.println("3. Generuj terminarz/rundę (tylko na początku)");
            System.out.println("4. Wyświetl tabelę / drabinkę");
            System.out.println("5. Wpisz wyniki kolejki / rund");
            System.out.println("0. Zakończ");
            System.out.println("Wybierz opcję: ");

            if (scanner.hasNextInt()) {
                wybor = scanner.nextInt();
                scanner.nextLine();
                procesujWybor(wybor);
            } else {
                System.out.println("Niepoprawny znak! Wpisz liczbę!");
                scanner.next();
            }
        }
    }

    private void procesujWybor(int wybor) {
        switch (wybor) {
            case 1:
                stworzSezonZMenu();
                break;
            case 2:
                if (walidujCzySezonIstnieje()) {
                    rejestrujKlubZMenu();
                }
                break;
            case 3:
                if (walidujCzySezonIstnieje()) {
                    sezon.generujTerminarzSezonu();
                    System.out.println("Terminarz/Runda został/a wygenerowany pomyslnie");
                }
                break;
            case 4:
                if (walidujCzySezonIstnieje()) {
                    System.out.println("--- AKTUALNA TABELA ---");
                    sezon.generujTabele();
                }
                break;
            case 5:
                if (walidujCzySezonIstnieje()) {
                    System.out.println("Podaj numer kolejki do rozegrania: ");
                    if (scanner.hasNextInt()) {
                        int nrKolejki = scanner.nextInt();
                        scanner.nextLine();
                        try {
                            sezon.wpiszWyniki(nrKolejki);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("BŁĄD: Taka kolejka nie istnieje w terminarzu! Najpierw wygeneruj terminarz.");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Niepoprawny numer kolejki.");
                        scanner.next();
                    }
                }
                break;
            case 0:
                System.out.println("Koniec programu.");
                break;
            default:
                System.out.println("Nieznana opcja, spróbuj ponownie: ");
        }
    }

    private boolean walidujCzySezonIstnieje() {
        if (sezon == null) {
            System.out.println("BŁĄD: Najpierw musisz stworzyć sezon (Opcja 1)!");
            return false;
        }
        return true;
    }

    private void stworzSezonZMenu() {
        System.out.print("Podaj nazwę dla nowego sezonu: ");
        String nazwa = scanner.nextLine();

        if (nazwa.trim().isEmpty()) {
            System.out.println("BŁĄD: Nazwa sezonu nie może być pusta!");
            return;
        }

        System.out.println("Wybierz rodzaj rozgrywek:");
        System.out.println("1. Ekstraklasa (Liga):");
        System.out.println("2. Puchar Polski (Puchar)");
        System.out.print("Wybierz opcję: ");

        int typ = 0;
        if (scanner.hasNextInt()) {
            typ = scanner.nextInt();
            scanner.nextLine();
        } else {
            scanner.next();
        }

        if (typ == 1) {
            this.sezon = new Ekstraklasa(nazwa);
            System.out.println("Pomyślnie utworzono Ligę: " + nazwa);
        } else if (typ == 2) {
            this.sezon = new PucharPolski(nazwa);
            System.out.println("Pomyślnie utworzono Ligę: " + nazwa);
        } else {
            System.out.println("Niepoprawny wybór! Sezon nie został utworzony");
            return;
        }
        this.nastepneIdKlubu = 1;
    }

    private void rejestrujKlubZMenu() {
        System.out.print("Podaj nazwę nowego klubu: ");
        String nazwa = scanner.nextLine();

        if (nazwa.trim().isEmpty()) {
            System.out.println("BŁĄD: Nazwa klubu nie może być pusta!");
            return;
        }

        Klub nowyKlub = new Klub(nastepneIdKlubu, nazwa);
        sezon.zarejestrujKlub(nowyKlub);
        nastepneIdKlubu++;
    }
}