# Laboratorul 6
### Interfețe grafice cu utilizatorul (Swing, JavaFX)
Luați în considerare un joc pozițional jucat pe o tablă în formă de grilă. O grilă este o structură bidimensională de linii care se intersectează, liniile sunt uniform distanțate, intersectându-se în unghi drept.
La începutul jocului, vor fi plasate aleatoriu jetoane mici în formă de linie ( bețe ) care leagă două intersecții adiacente ale rețelei, de-a lungul unei linii a rețelei.
O intersecție care este adiacentă cu cel puțin un stick se numește nod .
Primul jucător selectează orice nod al grilei și plasează un jeton circular ( piatră ) pe acesta. Apoi, jucătorii trebuie să aleagă alternativ un nou nod neselectat care este adiacent (este conectat printr-un stick) cu cel selectat anterior și să pună o piatră pe el. Ei folosesc pietre de diferite culori. Jucătorul care nu poate alege un alt nod, pierde jocul.
Pentru a crea o interfață grafică cu utilizatorul pentru joc, puteți utiliza fie Swing, fie JavaFX.

## Compulsory 
* Cadrul principal al aplicației.
* Un panou de configurare pentru introducerea parametrilor privind dimensiunea grilei și un buton pentru crearea unui nou joc. Panoul trebuie plasat în partea superioară a cadrului. Panoul trebuie să conțină cel puțin o etichetă și o componentă de intrare.
* O pânză (panou de desen) pentru desenarea tablei. Desenați liniile grilei în funcție de valorile specificate în panoul de configurare. Acest panou trebuie plasat în partea centrală a cadrului.
* Un panou de control pentru gestionarea jocului. Acest panou va conține butoanele: Încărcare , Salvare , Ieșire , etc. și va fi plasat în partea de jos a cadrului.

![imagine joc](https://github.com/iulica04/Advanced-Programming/blob/ccfafaa9a33e98169e07b66f418c91b71e4de3df/Laborator_6/joculetJava.png)

## Homework
* Creați modelul orientat pe obiecte.
* Inițializați jocul generând stick-uri aleatorii și plasați-le pe tablă. Implementați modul direct sau reținut pentru desenarea tablei de joc.
* Implementați logica jocului. Când jucătorul execută o operație apăsată cu mouse-ul , trebuie desenată o piatră în locația mouse-ului: roșu sau albastru, în funcție de rândul cui este. Validați mișcarea, conform regulilor jocului. Determinați câștigătorul jocului.
* (+0,5p) Exportați imaginea curentă a tablei de joc într-un fișier PNG.
* (+0,5p) Utilizați serializarea obiectelor pentru a salva și a restabili starea curentă a jocului.

![imagine_joc2](https://github.com/iulica04/Advanced-Programming/blob/5778f056a151aa062a5350579ae709ce6736f331/Laborator_6/Joc.png)