repete(0, _, []).
repete(N, C, L) :-
 N > 0,
 L = [C | T],
 N1 is N - 1,
 repete(N1, C, T).
% 1) Defina um predicado odd(N) que seja verdadeiro se N for um número ímpar. Exemplo de uso:
impar(X) :- AUX is mod(X,2), AUX == 1.

% 2) Defina um predicado recursivo hasN(L,N) que seja verdadeiro se L for uma lista de N elementos.
hasN([],_).
hasN(L,N) :- L = [H|T], H == N, hasN(N,T).

% 3) Defina um predicado recursivo inc99(L1,L2), de forma que L2 seja uma lista com todos os elementos de L1 acrescidos da constante 99.
inc99([],[]).
inc99(L1,L2):- L1 = [H1|T1],L2 = [H2|T2], H2 is H1 + 99,inc99(T1,T2).

% 4) Defina um predicado recursivo incN(L1,L2,N), de forma que L2 seja uma lista com todos os elementos de L1 acrescidos da constante N.
incN([],[],_).
incN(L1,L2,N):- L1 = [H1|T1],L2 = [H2|T2], H2 is H1 + N,incN(T1,T2,N).

% 5) Defina um predicado recursivo comment(L1,L2), de forma que L1 seja uma lista de strings e L2 tenha todos os elementos de L1 concatenados com o prefixo "%%". Dica: consulte predicados Prolog para manipulação de strings.
comment([],[]).
comment(L1,L2):- L1 = [H1|T1],L2 = [H2|T2], string_concat("%%",H1,H2),comment(T1,T2).
% 6) Defina um predicado recursivo onlyEven(L1,L2), de forma que L2 seja uma lista só com os elementos pares de L1, conforme o exemplo abaixo:
onlyEven([],[]).
onlyEven(L1,L2):- L1 = [H1|T1],L2 = [H2|T2],not(impar(H1)),H2 = H1,onlyEven(T1,T2).
onlyEven(L1,L2):- L1 = [H1|T1],L2 = T2,impar(H1),onlyEven(T1,T2).
% 7) Defina um predicado recursivo countdown(N,L), de forma que L seja uma lista com os números [N, N-1, N-2, .., 1], sendo N um número positivo. Exemplo:
countdown(0,[]).
countdown(N,L) :- N >= 0, L = [H|T], H = N,N1 is N-1, countdown(N1,T).
% 8) Defina um predicado recursivo nRandoms(N,L), de forma que L seja uma lista com N números gerados aleatoriamente, conforme os exemplos abaixo:
nRandoms(0,[]).
nRandoms(N,L) :- N >= 0, L = [H|T], random(0,1000,H),N1 is N-1, nRandoms(N1,T).
% 9) Defina um predicado recursivo potN0(N,L), de forma que L seja uma lista de potências de 2, com expoentes de N a 0. Exemplo de uso:
potN0(0,[]).
potN0(N,L) :- N >= 0, L = [H|T], pow(2,N,H),N1 is N-1, potN0(N1,T).
% 10) Defina um predicado recursivo zipmult(L1,L2,L3), de forma que cada elemento da lista L3 seja o produto dos elementos de L1 e L2 na mesma posição do elemento de L3. Exemplo:
zipMult([],[],[]).
zipMult(L1,L2,L3) :- L1 = [H1|T1],L2 = [H2|T2], L3 = [H3|T3], H3 is H2 * H1, zipMult(T1,T2,T3).
% 11) Defina um predicado recursivo potencias(N,L), de forma que L seja uma lista com as N primeiras potências de 2, sendo a primeira 2^0 e assim por diante, conforme o exemplo abaixo:
potencias(0,[]).
potencias(1,1).
potencias(N,L) :- N >= 0, L = [H|H1|T], H1 is H*2,N1 is N-1, potencias(N1,T).
% 12)
