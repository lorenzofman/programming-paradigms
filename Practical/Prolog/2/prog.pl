is_member(A,[H|T]) :- A == H ; is_member(A,T).

ao_lado(X,Y,L) :- nextto(X,Y,L) ; nextto(Y,X,L).
um_entre(X,Y,L) :- ao_lado(Z,X,L) , ao_lado(Z,Y,L).

/*
@ O avião do Cel. Milton solta fumaça vermelha.
@ O rádio transmissor do Ten. Walter está com problemas.
@ O piloto do avião que solta fumaça verde adora pescar.
@ O Major Rui joga futebol nos finais de semana.
@ O avião que solta fumaça verde está imediatamente à direita do avião que solta fumaça branca.
@ O piloto que bebe leite está com o altímetro desregulado.
@ O piloto do avião que solta fumaça preta bebe cerveja.
@ O praticante de natação pilota o avião que solta fumaça vermelha.
@ O Cap. Farfarelli está na ponta esquerda da formação.
@ O piloto que bebe café voa ao lado do avião que está com pane no sistema hidráulico.
@ O piloto que bebe cerveja voa ao lado do piloto que enfrenta problemas na bússola.
@ O homem que pratica equitação gosta de beber chá.
@ O Cap. Nascimento bebe somente água.
@ O Cap. Farfarelli voa ao lado do avião que solta fumaça azul.
Na formação, há um avião entre o que tem problema hidráulico e o com pane no altímetro.
Um dos pilotos joga tênis.
Há um avião com problema de temperatura.
Dica final: use o predicado um_entre criado em outro exercício.
*/
% Squad = (Name,SmokeColor,Sport,Drink,Anomaly)
squadSolution(Squad) :-
  Squad = [_,_,_,_,_],
  member(squad(milton     , red      , _      , _     , _         ), Squad),
  member(squad(walter     , _        , _      , _     , radio     ), Squad),
  member(squad(_          , green    , fishing, _     , _         ), Squad),
  member(squad(rui        , _        , soccer , _     , _         ), Squad),
  member(squad(_          , _        , _      , milk  , altimeter ), Squad),
  member(squad(_          , black    , _      , beer  , _         ), Squad),
  member(squad(_          , red      , swim   , _     , _         ), Squad),
  member(squad(_          , _        , _      , _     , _         ), Squad),
  member(squad(_          , _        , horses , tea   , _         ), Squad),
  member(squad(born       , _        , _      , water , _         ), Squad),
  member(squad(_          , _        , _      , _   , _           ), Squad),
  um_entre(squad(_ , _, _, _, hydra), squad(_, _, _, _, altimeter ), Squad),
  member(squad(_          , _        , tenis  , _ , _             ), Squad),
  member(squad(_          , _        , _  , _ , temperature       ), Squad),
  ao_lado(squad(farfarelli, _, _, _, _), squad(_, blue, _, _, _ ), Squad),
  ao_lado(squad(_, _, _, _, hydra), squad(_, _, _, coffe, _ ), Squad),
  ao_lado(squad(_, _, _, _, compass), squad(_, _, _, beer, _ ), Squad),
  [squad(farfarelli,_,_,_,_),_,_,_,_] = Squad,
  nextto(squad(_,white,_,_,_), squad(_,green,_,_,_   ), Squad).

positivos1([],[]).
positivos1([H|T],L) :- H > 0, positivos1(T,Resto), L = [H|Resto].
positivos1([H|T],L) :- H =< 0, positivos1(T,L).

positivos2([],[]).
positivos2([H|T],L) :- H > 0, L = [H|Resto], positivos2(T,Resto).
positivos2([H|T],L) :- H =< 0, positivos2(T,L).
