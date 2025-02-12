# Raport z projektu zaliczeniowego - Testy API

## Opis projektu
Projekt jest zestawem testów API Magic: The Gathering (MTG), wykorzystującym frameworki **Rest-Assured** oraz **TestNG**. Testy pokrywają wszystkie endpointy API, zarówno pod kątem pozytywnych jak i negatywnych scenariuszy (wartości zwracane, obsługa błędów, weryfikacja kodów HTTP).

## Technologie i narzędzia
- **Język:** Java 21  
- **Frameworki:** TestNG, Rest-Assured  
- **Build tool:** Maven  
- **CI/CD:** GitHub Actions  

## Zakres testów  

### Testy dla kart **\</cards>**
- **Pobieranie wszystkich kart**
- **Wyszukiwanie kart po nazwie**
- **Pobieranie kart po unikalnym ID**
- **Filtrowanie kart po parametrach** *(layout, cmc, typ, kolor itd.)*
- **Porównanie danych kart odpowiedzi API ze statycznymi przypadkami**  

### Testy dla zestawów **\</sets>**
- **Pobieranie wszystkich zestawów**
- **Pobieranie zestawów po ID**
- **Wyszukiwanie zestawów po parametrach** *(nazwa, kod, typy itd.)*  
- **Porównanie danych setów odpowiedzi API ze statycznymi przypadkami**  

### **Testy dla metadanych**
- **Pobieranie typów kart **\</types>****
- **Pobieranie podtypów **\</subtypes>****
- **Pobieranie supertypów **\</supertypes>****
- **Pobieranie formatów rozgrywki **\</formats>****  

## Integracja z GitHub Actions
Projekt jest zintegrowany z **GitHub Actions**, pozwalając na wykonanie testów na żądanie oraz przechowywanie logów zgodnie z *plikiem Workflow* - `tests.yml`.  
Prosta modyfikacja pliku Workflow pozwoliłaby na pełną automatyzację testów poprzez ich cykliczne uruchamianie.

