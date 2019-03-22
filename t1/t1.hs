import Data.Char
{-1-} -- Crie uma função isVowel :: Char -> Bool que verifique se um caracter é uma vogal ou não.
myIsLetter :: Char -> [Char] -> Bool
myIsLetter c str = elem c str
isVowel :: Char ->  Bool
isVowel c =  myIsLetter c "aeiouAEIOU"

{-2-} -- Escreva uma função addComma, que adicione uma vírgula no final de cada string contida numa lista.
addComma :: [String] -> [String]
addComma strings = map (\str -> str ++ ",") strings

{-3-} -- Crie uma função htmlListItems :: [String] -> [String], que receba uma lista de strings e retorne outra lista contendo as strings formatadas como itens de lista em HTML. Resolva este exercício COM e SEM funções anônimas (lambda). Exemplo de uso da função:
addHtml :: String -> String
addHtml str = "<LI>" ++ str ++ "</LI>"
htmlListItems  :: [String] -> [String] -- (Lambda)
htmlListItems' strings = map (\str -> "<LI>" ++ str ++ "</LI>") strings
htmlListItems' :: [String] -> [String] -- (Non-lambda)
htmlListItems strings = map addHtml strings

{-4-} -- Defina uma função que receba uma string e produza outra retirando as vogais, conforme os exemplos abaixo. Resolva este exercício COM e SEM funções anônimas (lambda).
semVogais :: String -> String -- (Lambda)
semVogais str = filter (\c -> (notElem c "aeiouAEIOU")) str
semVogais' :: String -> String -- (Non-lambda)
semVogais' str = filter (not . isVowel) str

{-5-} -- Defina uma função que receba uma string, possivelmente contendo espaços, e que retorne outra string substituindo os demais caracteres por '-', mas mantendo os espaços. Resolva este exercício COM e SEM funções anônimas (lambda)
codificaChar :: Char -> Char
codificaChar c = (if c == ' ' then ' ' else '-')
codifica :: String -> String -- (Lambda)
codifica str = map (\c -> (if c == ' ' then ' ' else '-')) str
codifica' :: String -> String -- (Non-Lambda)
codifica' str = map codificaChar str

{-6-} -- Escreva uma função firstName :: String -> String que, dado o nome completo de uma pessoa, obtenha seu primeiro nome. Suponha que cada parte do nome seja separada por um espaço e que não existam espaços no início ou fim do nome.
firstName :: String -> String
firstName str = takeWhile (/= ' ') str
{-7-} -- Escreva uma função isInt :: String -> Bool que verifique se uma dada string só contém dígitos de 0 a 9.
isInt :: String -> Bool
isInt x = length (filter (\c -> myIsLetter c "0123456789") x) == length x
{-8-} -- Escreva uma função lastName :: String -> String que, dado o nome completo de uma pessoa, obtenha seu último sobrenome. Suponha que cada parte do nome seja separada por um espaço e que não existam espaços no início ou fim do nome
lastName :: String -> String
lastName str = reverse (takeWhile (/= ' ') (reverse str))
{-9-} -- Escreva uma função userName :: String -> String que, dado o nome completo de uma pessoa, crie um nome de usuário (login) da pessoa, formado por: primeira letra do nome seguida do sobrenome, tudo em minúsculas
userName :: String -> String
userName name =  map toLower ([head name] ++ (lastName name))
{-10-} -- Escreva uma função encodeName :: String -> String que substitua vogais em uma string
encodeChar :: Char -> Char
encodeChar c 
    | c == 'a' || c == 'A' = '4'
    | c == 'e' || c == 'E' = '3'
    | c == 'i' || c == 'I' = '2'
    | c == 'o' || c == 'O' = '1'
    | c == 'u' || c == 'U' = '0'
    | otherwise = c
encodeName :: String -> String
encodeName name = map encodeChar name
