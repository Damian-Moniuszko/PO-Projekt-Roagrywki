# Dokumentacja Projektu: Symulator Rozgrywek Piłkarskich

Aplikacja stanowi kompletny, obiektowy system zarządzania i symulacji krajowych rozgrywek piłkarskich w dwóch niezależnych formatach: ligowym oraz pucharowym.

### Cel i rozwiązywany problem
Głównym celem projektu jest automatyzacja procesu planowania, zarządzania oraz rejestracji wyników w rozgrywkach sportowych. 
Aplikacja rozwiązuje ten problem, oferując cyfrowy "silnik" rozgrywek piłkarskich, który w sposób automatyczny:
1. Generuje pary meczowe.
2. Pilnuje spójności historycznej danych (blokada ponownego rozgrywania meczu).
3. Oblicza statystyki zespołów.


### Główne funkcjonalności
* **Dynamiczne zarządzanie strukturą:** Możliwość utworzenia nowego sezonu o dowolnej nazwie i rejestracji klubów z automatycznym przydzielaniem unikalnych identyfikatorów (ID).
* **Wybór trybu:**
  * **Ekstraklasa (Liga):** Automatyczne generowanie pełnego terminarza systemem "każdy z każdym" oraz prowadzenie klasycznej tabeli punktowej (3 pkt za wygraną, 1 pkt za remis).
  * **Puchar Polski (Turniej pucharowy):** Maszyna losująca pary w systemie pucharowym. Przegrany odpada z rozgrywek, wygrany przechodzi do kolejnej rundy.
* **Wprowadzanie wyników:** Interfejs walidujący wprowadzane bramki (blokada liczb ujemnych) z automatyczną aktualizacją statystyk klubowych.
* **Zaawansowana logika pucharowa:** Obsługa dogrywek/rzutów karnych w przypadku remisu w Pucharze Polski, wymuszająca wskazanie ostatecznego zwycięzcy meczu.
* **Odporność na błędy:** Menu wyposażone w pełną kontrolę typów (zabezpieczenie przed wpisaniem liter zamiast liczb) oraz blokady logiczne (np. brak możliwości wygenerowania tabeli przed rejestracją klubów).

---

### Podział ról
Wiktor Żakowicz- zaprojektowanie algorytmow losowania, implementacja klasy abstrakcyjnej
Michał Zieleniecki - zaprojektowanie menu i mechanizmu odczyt/zapis
Damian Moniuszko - zaprojektowanie glownych klas oraz struktury wyjatkow