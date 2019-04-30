assassin(WHO) :- reason(WHO), access(WHO).

    % Assassin predicates
    reason(WHO) :- jealous(WHO); insane(WHO); money(WHO).
    access(WHO) :- key(WHO), weapon(WHO), not(alibi(WHO)).
        % Access predicates
        key(WHO) :- track(WHO,sm,wednesday) ; track(WHO,poa,tuesday).
        weapon(WHO) :- baseballBat(WHO) ; hammer(WHO).
            % Weapon predicates
            baseballBat(WHO) :- track(WHO,poa,thursday); track(WHO,sm,wednesday);
            hammer(WHO) :- track(WHO,ap,wednesday) ; track(WHO,ap,thursday).
        % Reason predicates
        jealous(X,Y) :- love(X,Z),  love(Z,Y).
        insane(WHO).
        money(WHO) :- poor(X).
    % General predicates
    relation (X,Y).
    poor(X).
    track(WHO,WHERE,WHEN).
    % What Hercule Poirot know?
    insane(adriano).
    insane(maria).