# Shunting_Yard_Algorithm
The shunting yard algorithm is used to convert the infix notation to reverse polish notation. It is a method for representing expressions in which the operator symbol is placed after the arguments being operated on.

Pseudocode:

1. cat timp exista o entitate de citit:
    - citeste entitatea (i.e. operand sau operator)
        - daca entitatea este un operand (i.e. un numar), atunci adauga la forma postfixata
    - daca entitatea este un operator (fie el O1), atunci:
        - cat timp (exista un operator in varful stivei (fie el O2)) SI (O2 este diferit de paranteza-stanga) SI
                      (precedenta(O1) < precedenta(O2) SAU precedenta(O1) = precedenta(O2) SI O2 are asociativitate-stanga)
                      extrage O2 si adauga-l la forma postfixata
        - adauga O1 in stiva
    - daca entitatea este o paranteza-stanga, atunci:
        - adauga paranteza in stiva
    - daca entitatea este o paranteza-dreapta, atunci:
        - cat timp operatorul din varful stivei (fie el O) nu este paranteza-stanga:
            - extrage O si adauga-l la forma postfixata
        - daca stiva s-a golit (si nu s-a gasit o paranteza-stanga)
            - returneaza eroare (i.e. expresia avea paranteze gresite)
        - extrage paranteza-stanga din varful stivei
 
// in acest moment nu mai sunt entitati de citit
 
2. cat timp exista operator in stiva (fie el O)
    - extrage O si adauga-l la forma postfixata
    - daca O este o paranteza-stanga, atunci:
        - returneaza eroare (i.e. expresia avea paranteze gresite)
 
3. afiseaza / returneaza forma postfixata
