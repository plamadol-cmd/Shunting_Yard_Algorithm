# Shunting_Yard_Algorithm
The shunting yard algorithm is used to convert the infix notation to reverse polish notation. It is a method for representing expressions in which the operator symbol is placed after the arguments being operated on.

Pseudocode:

1. cat timp exista o entitate de citit:
    1.1 citeste entitatea (i.e. operand sau operator)
    1.2. daca entitatea este un operand (i.e. un numar), atunci:
        1.2.1 adauga la forma postfixata
    1.3 daca entitatea este un operator (fie el O1), atunci:
        1.3.1 cat timp (exista un operator in varful stivei (fie el O2)) SI
        (O2 este diferit de paranteza-stanga) SI
                      (precedenta(O1) < precedenta(O2) SAU 
                       precedenta(O1) = precedenta(O2) SI O2 are asociativitate-stanga)
            1.3.1.1 extrage O2 si adauga-l la forma postfixata
        1.3.2 adauga O1 in stiva
    1.4 daca entitatea este o paranteza-stanga, atunci:
        1.4.1 adauga paranteza in stiva
    1.5 daca entitatea este o paranteza-dreapta, atunci:
        1.5.1 cat timp operatorul din varful stivei (fie el O) nu este paranteza-stanga:
            1.5.1.1 extrage O si adauga-l la forma postfixata
        1.5.2 daca stiva s-a golit (si nu s-a gasit o paranteza-stanga)
            1.5.2.1 returneaza eroare (i.e. expresia avea paranteze gresite)
        1.5.3 extrage paranteza-stanga din varful stivei
 
// in acest moment nu mai sunt entitati de citit
 
2. cat timp exista operator in stiva (fie el O)
    2.1 extrage O si adauga-l la forma postfixata
    2.2 daca O este o paranteza-stanga, atunci:
        2.2.1 returneaza eroare (i.e. expresia avea paranteze gresite)
 
3. afiseaza / returneaza forma postfixata
