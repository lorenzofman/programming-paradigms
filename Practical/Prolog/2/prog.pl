is_member(A,[]) :- false.
is_member(A,[H|T]) :- A == H ; is_member(A,T).

ao_lado(X,Y,L) :- nextto(X,Y,L) ; nextto(Y,X,L).
um_entre(X,Y,L) :- ao_lado(Z,X,L) , ao_lado(Z,Y,L).
