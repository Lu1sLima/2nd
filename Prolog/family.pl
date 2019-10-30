parent(antonio,joaozinho).
parent(maria,joaozinho).
parent(antonio,luis).
parent(maria,luis).
parent(antonio, cristina).
parent(maria, cristina).
parent(carlos, antonio).
parent(fernanda, antonio).
parent(pedro, maria).
parent(mariana, maria).
parent(jose, mariana).
parent(sandra, mariana).
parent(carlos, alberto).
parent(fernanda, alberto).
parent(carlos, marcia).
parent(fernanda, marcia).

father(X, Y) :- parent(X,Y), gender(X, male).
mother(X, Y) :- parent(X, Y), gender(X, fem).
brother(X, Y) :- parent(Z, X), parent(Z, Y), gender(X, male), X \== Y.
sister(X, Y) :- parent(Z, X), parent(Z, Y), gender(X, fem), X \== Y.
uncle(X, Y) :- brother(X, Z), gender(X, male), parent(Z, Y).
aunt(X, Y) :- sister(X, Z), gender(X, fem), parent(Z, Y).

grandfather(X, Y) :- parent(Z, Y), father(X, Z).
grandmother(X, Y) :- parent(Z, Y), mother(X, Z).

great-grandfather(X, Y) :- parent(Z, Y), grandfather(X, Z).
great-grandmother(X, Y) :- parent(Z, Y), grandmother(X, Z).
ancestor(X, Y) :- parent(X,Y).
ancestor(X, Y) :- parent(X, Z), ancestor(Z, Y).


gender(mariana, fem).
gender(marcia, fem).
gender(maria,fem).
gender(cristina, fem).
gender(fernanda, fem).
gender(sandra, fem).
gender(joaozinho,male).
gender(antonio,male).
gender(luis, male).
gender(carlos, male).
gender(pedro, male).
gender(jose, male).
gender(alberto, male).
