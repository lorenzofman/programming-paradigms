assassin(WHO) :- reason(WHO), access(WHO).
    % Assassin predicates
    reason(WHO) :- jealous(maria,WHO); insane(WHO); money(WHO).
    access(WHO) :- key(WHO), weapon(WHO).
        % Access predicates
        key(WHO) :- track(WHO,sm,wednesday) ; track(WHO,poa,tuesday).
        weapon(WHO) :- baseballBat(WHO) ; hammer(WHO).
            % Weapon predicates
            baseballBat(WHO) :- track(WHO,poa,thursday) ; track(WHO,sm,wednesday).
            hammer(WHO) :- track(WHO,ap,wednesday) ; track(WHO,ap,thursday).
        % Reason predicates
        jealous(X,Y) :- relation(X,Z),  relation(Z,Y).
        money(WHO) :- poor(WHO).
    % General predicates
        % relation(W,M).
        % poor(WHO).
        % track(WHO,WHERE,WHEN).
        % insane(WHO).
    % What Hercule Poirot know?
    insane(adriano).
    insane(maria).

    % Bia has a key no matter where she had been

    % Relations (W,M)
    relation(anita,bernardo).
    relation(caren,bernardo).
    relation(anita,pedro).
    relation(alice,pedro).
    relation(alice,henrique).
    relation(maria,henrique).
    relation(maria,adriano).
    relation(caren,adriano).
    % Poor people
    poor(bia). 
    poor(pedro).
    poor(maria).

    % Tracking
    track(pedro,sm,monday).
    track(pedro,sm,tuesday).
    track(pedro,poa,wednesday).
    track(pedro,sm,thursday).
    track(pedro,ap,friday).

    track(caren,poa,monday).
    track(caren,poa,thursday).
    track(caren,poa,wednesday).
    track(caren,sm,thursday).
    track(caren,ap,friday).

    track(henrique,ap,monday).
    track(henrique,poa,thursday).
    track(henrique,ap,wednesday).
    track(henrique,ap,thursday).
    track(henrique,ap,friday).

    track(bia,ap,monday).
    track(bia,poa,thursday).
    track(bia,poa,wednesday).
    track(bia,sm,thursday).
    track(bia,ap,friday).

    track(adriano,ap,monday).
    track(adriano,ap,thursday).
    track(adriano,poa,wednesday).
    track(adriano,ap,thursday).
    track(adriano,ap,friday).

    track(alice,ap,monday).
    track(alice,poa,thursday).
    track(alice,poa,wednesday).
    track(alice,ap,thursday).
    track(alice,ap,friday).

    track(bernardo,sm,monday).
    track(bernardo,sm,thursday).
    track(bernardo,poa,wednesday).
    track(bernardo,sm,thursday).
    track(bernardo,ap,friday).

    track(maria,ap,monday).
    track(maria,sm,thursday).
    track(maria,sm,wednesday).
    track(maria,sm,thursday).
    track(maria,ap,friday).

    