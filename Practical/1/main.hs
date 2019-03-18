--  1) Crie uma função sumSquares :: Int -> Int -> Int que calcule a soma dos quadrados de dois números x e y.
sumSquares :: Int -> Int -> Int 
sumSquares x y = x^2 + y^2

--  2) Crie uma função hasEqHeads :: [Int] -> [Int] -> Bool que verifique se 2 listas possuem o mesmo primeiro elemento. Use a função head e o operador lógico == para verificar igualdade.
hasEqHeads :: [Int] -> [Int] -> Bool
hasEqHeads list1 list2 = head list1 == head list2

--  3) Escreva uma função que receba uma lista de nomes e adicione a string "Super " no início de cada nome. Use o operador ++ para concatenar strings (ou qualquer lista).
superString :: [Char] -> [Char]
superString notSuperStr = "Super" ++ notSuperStr

--  4) Crie uma função que receba uma string e retorne o número de espaços nela contidos. Dica: aplique 2 funções consecutivamente.
spaceChars :: [Char] -> Int
spaceChars str = length (filter (\x -> x == ' ')  str)

--  5) Escreva uma função que, dada uma lista de números, calcule 3*n^2 + 2/n + 1 para cada número n da lista. Dica: defina uma função anônima.
--calculateFormula :: [Int] -> [Int]
--calculateFormula list = map((\x -> x == 3*x^2 + 2/x + 1), list)

--  6) Escreva uma função que, dada uma lista de números, selecione somente os que forem negativos.

--  7) Escreva uma função que receba uma lista de números e retorne somente os que estiverem entre 1 e 100, inclusive. Dica 1: defina uma função anônima. Dica 2: use o operador && para expressar um 'E' lógico.

--  8) Escreva uma função que, dada uma lista de idades de pessoas no ano atual, retorne uma lista somente com as idades de quem nasceu depois de 1980. Para testar a condição, sua função deverá subtrair a idade do ano atual.

--  9) Escreva uma função que receba uma lista de números e retorne somente aqueles que forem pares.

--  10) Crie uma função charFound :: Char -> String -> Bool que verifique se o caracter (primeiro argumento) está contido na string (segundo argumento). Exemplos de uso da função:

--  11) Crie uma função que receba uma lista de nomes e retorne outra lista com somente aqueles nomes que terminarem com a letra 'a'. Dica: conheça o list monster, do autor Miran Lipovača :-)

--  12) A função takeWhile :: (a -> Bool) -> [a] -> [a] é uma função de alta ordem. Ela recebe uma função condicional e uma lista, retornando o "menor prefixo" (isto é, porção inicial) da lista que satisfaça a condição dada. Teste os exemplos abaixo no GHCi e depois crie um novo exemplo:

