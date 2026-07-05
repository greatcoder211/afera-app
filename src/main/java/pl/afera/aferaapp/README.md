--- Layout --- 
1) Panel główny
   (a) Zobacz listę afer -> Lista afer:
1.1) Panel listy afer
Dla każdej afery: 
   {- Tytuł(np. "Afera Podkarpacka")
   - Opis
   - Ile kasy
   - Zamieszane partie
   - Zamieszani politycy(w formacie: Chlebowski(PO), Romanowski(PiS))}
   - Zamieszane znane osoby 
- (b) Zgłoś aferę -> Zgłoś aferę

1.2) Panel zgłoszenia
   - krótki podtytuł("dzięki, że zgłaszasz")
   - Nazwa afery
   - Opis
   - Ile kasy
   - Podaj źródła
   - Ile kasy
   - Podaj źródła
   - Politycy, partie, znane osobistości
   - Podaj źródła
   - Wolne wnioski(ogromne pole tekstowe), jak chcesz- zostaw nam jakiś kontakt. Być może będziemy chcieli się z tobą skontaktować. 
[jak kontakt -> to RODO]
2) Panel admina
   
(a) Zobacz listę afer(przekieruj do 1.1)
[docelowo admin ma swoją listę afer, aferę z publicznej listy, może sobie "przyciągnąć" i nad nią popracować(np. jak zauważy jakieś kłamstwo/niespójność/nieścisłość)]
   (b) Sprawdź zgłoszenia -> pokaże mu się lista zgłoszeń, która może zaakcpetować/odrzucić
[także później: edytować]
// (i) -> (i) dto < architektura heksagonalna
---Endpointy---
1) Admin
- "/admin": wyjściowy widok admina
- "/admin/add": sprawdza nadesłany, konkretny formularz, może go zaakceptować lub odrzucić
- "/admin/check": lista wszystkich reportów od użytkowników, może zedytować i zatwierdzić lub odrzucić 
- "/admin/all-scandals": lista wszystkich afer z perspektywy admina
- "/admin/edit": "wyciąga" aferę z bazy, edytuje(np. poprawia daty) i z powrotem zapisuje
2) ScandalList
"/all-scandals": lista wszystklich scandali
"/all-scandals/{id}" np. "/all-scandals/2" pokaże konkretną(tu: drugą) aferę
3) ScandalReport
"/report/show": wyswietli nam się pusty formularz wypełniania
a pod "/report" wysyłamy
