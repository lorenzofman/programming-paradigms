{-1-}
add10toall :: [Int] -> [Int]
add10toall list = [x + 10 | x <- list]
{-2-}
multN :: Int -> [Int] -> [Int]
multN n list = [x * n | x <- list]
{-3-} -- Usando list comprehension, defina uma função applyExpr :: [Int] -> [Int], que receba uma lista e calcule 3*x+2 para cada elemento x da lista, produzindo outra lista.
applyExpr :: [Int] -> [Int]
applyExpr list = [3*x +2 | x <- list]
{-4-} -- Usando list comprehension, escreva uma função addSuffix :: String -> [String] -> [String] , para adicionar um dado sufixo às strings contidas numa lista. Exemplo:
addSuffix :: String -> [String] -> [String]
addSuffix string listOfStrings = [str ++ string | str <- listOfStrings]
{-5-} -- Usando list comprehension, defina uma função selectgt5 :: [Int] -> [Int], que receba uma lista e selecione somente os valores maiores que 5, produzindo outra lista.
selectgt5 :: [Int] -> [Int]
selectgt5 list = [x | x <- list, x > 5]
{-6-} -- Usando list comprehension, defina uma função sumOdds :: [Int] -> [Int], que receba uma lista e obtenha o somatório dos valores ímpares, produzindo outra lista. Pesquise funções auxiliares que manipulem listas.
sumOdds :: [Int] -> [Int]
sumOdds list = [sum [x | x <- list, x `mod` 2 == 1]]
{-7-} -- Usando list comprehension, defina uma função selectExpr :: [Int] -> [Int], que receba uma lista e selecione somente os valores pares entre 20 e 50, produzindo outra lista.
selectExpr :: [Int] -> [Int]
selectExpr ls = [x | x <- ls, x `mod` 2 == 0, x > 20, x < 50]
{-8-} -- Escreva uma função countShorts :: [String] -> Int, que receba uma lista de palavras e retorne a quantidade de palavras dessa lista que possuem menos de 5 caracteres. Use list comprehension.
countShorts :: [String] -> Int
countShorts list = length [x | x <- list, length x < 5]
{-9-} -- Escreva uma função calcExpr :: [Float] -> [Float], que calcule x^2/2 para cada elemento x da lista de entrada e selecione apenas os resultados que forem maiores que 10. Use list comprehension.
calcExpr :: [Float] -> [Float]
calcExpr list = [x^2/2 | x <- list, x^2/2 > 10]

{-10-} -- Escreva uma função trSpaces :: String -> String, que receba uma string e converta espaços (' ') em traços ('-'). Use list comprehension.
trSpaces :: String -> String
trSpaces str = [if(c == ' ') then '-' else c | c <- str]

{-11-} -- Qual será o resultado de cada expressão abaixo?
-- a) [ (x,y) | x <- [1..5], even x, y <- [(x + 1)..6], odd y ]
-- b) [ a ++ b | a <- ["lazy","big"], b <- ["frog", "dog"]]
-- c) concat [ [a,'-'] | a <- "paralelepipedo", not (elem a "aeiou")]
-- Answers >
-- a) The result will be the pair, even number and all his odds sucessors
-- b) lazy frog, lazy dog, big frog, big dog
-- c) p-r-l-l-p-p-d-

{-12-} -- Defina uma função selectSnd :: [(Int,Int)] -> [Int], que receba uma lista de tuplas e selecione somente os segundos elementos dessas tuplas, produzindo outra lista. Use list comprehension.
selectSnd  :: [(Int,Int)] -> [Int]
selectSnd tuples = [snd tuple | tuple <- tuples]

{-13-} -- Em Haskell, a função zip combina elementos de duas listas, produzindo uma lista de tuplas. Por exemplo:
-- > zip [1,2] "ab"
-- [(1,'a'),(2,'b')]
-- > zip [1..] "abcde"
-- [(1,'a'),(2,'b'),(3,'c'),(4,'d'),(5,'e')]
-- Usando a função zip com list comprehension e outras funções auxiliares, escreva uma função dotProd :: [Int] -> [Int] -> [Int] que calcule o somatório dos produtos dos pares de elementos de duas listas, conforme o exempl
-- > dotProd [1,1,1,1] [2,2,2,2] -- 1*2 + 1*2 + 1*2 + 1*2
-- 8
dotProd :: [Int] -> [Int] -> Int
dotProd list1 list2 = sum [ x*y |(x,y) <- zip list1 list2]


{-14-} -- Nesta questão você também deverá usar list comprehension. Suponha que um retângulo seja representado por uma tupla (Float,Float,Float,Float), contendo respectivamente as coordenadas x e y do ponto no seu canto superior esquerdo, seguidas das suas medidas de largura e altura. Sabendo que o eixo x cresce de cima para baixo e o eixo y da esquerda para direita, crie uma função genRects :: Int -> (Int,Int) -> [(Float,Float,Float,Float)] que receba um número N e um ponto (x,y) e gere uma sequência de N retângulos não sobrepostos. Os retângulos devem ser alinhados pelos seus topos, a partir do ponto dado, com largura e altura constantes. Por exemplo, usando largura e altura iguais a 5.5:

-- > genRects 3 (0,0)
-- [(0.0,0.0,5.5,5.5),(5.5,0.0,5.5,5.5),(11.0,0.0,5.5,5.5)]
-- Obs.: Use conversão explícita de tipos quando misturar Int e Float.
genRects :: Int -> (Int,Int) -> [(Int,Int,Int,Int)]
genRects n tuple = [(x,y*5 + snd tuple,0,0) | (x,y) <- zip [fst tuple] [0..n]]

{-15-} -- Em Haskell, a função zipWith é uma função de alta ordem que aplica uma função a pares de elementos de duas listas. Pesquise sobre a função zipWith e utilize-a para definir uma função dotProd', que produza o mesmo resultado da função dotProd do exercício 13.
dotProd' :: [Int] -> [Int] -> Int
dotProd' list1 list2 = sum (zipWith(*) list1 list2)
