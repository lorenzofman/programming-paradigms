-- Sources to create the code
--https://wiki.haskell.org/Haskell_in_5_steps
--https://wiki.haskell.org/Learn_Haskell_in_10_minutes
--https://stackoverflow.com/questions/30242668/remove-characters-from-string-in-haskell

removeSpace xs = [ x | x <- xs, not (x `elem` " ") ]
main = do  
    putStrLn "Input any string"  
    string <- getLine  
    putStrLn ("Hey, here is your string without spaces: " ++ removeSpace string ++ ", you're welcome!")
    
-- How this code works:
-- There is no mystery in main, prints an initial string, reads one and then prints a formatted well written result
-- The important fact here is how removeSpace function work
-- xs is the removeSpace argument we are going to pass
-- Since Haskell is a functional programming language every input, no matter what memory state we are, will give the same output
-- We use [] to create a list of something
-- Since we're working with chars I assume haskell know how to print a list of chars and probably treats string like that in every case
-- I was doing my research here:
-- https://wiki.haskell.org/Cookbook/Lists_and_strings
-- For me it looks like a lambda expression, like if it was written something like this:
-- Create a list of x using xs as x and just get elements where x is not a space
-- Accordingly to http://hackage.haskell.org/package/bytestring-0.10.8.2/docs/Data-ByteString-Char8.html#v:elem
-- 'elem' looks like how haskell look for char equality
-- Replacing 'elem' with == gives the error * Couldn't match type `Char' with `[Char]
-- I loved the ease that is to create something that would take a little job in C
-- Reminds me of Python
