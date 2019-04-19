{- References:
    https://codereview.stackexchange.com/questions/68345/tictactoe-in-haskell
    https://gist.github.com/nick-paul/6a7df0112fe342ee828c9f6bd44a41ad
    https://www.schoolofhaskell.com/user/chad/snippets/a-tic-tac-toe-board
    Most important link: https://stackoverflow.com/questions/35507997/reading-user-mouseclick-position-in-haskells-gloss
    https://hackage.haskell.org/package/gloss-1.9.4.1/docs/
-}
-- Imports
import Graphics.Gloss
import Data.Maybe
import Data.List
import Control.Monad
import Control.Applicative
import Graphics.Gloss.Interface.Pure.Game
import Constants
-- Coordinates are used to place the crosses and the noughts
type Coordinates = (Int,Int)
-- A Player/Move can be a Nought or a Cross
data Player = Nought | Cross
-- The board is made up of a list of Coordinates that reference the noughts
-- A list of coordinates that reference the crosses
-- And the player that has the current turn
-- The board is passed as parameter and when needed to update returns back
-- Basically x = f(x)
-- It isn't pure pure functional but it is a way of doing it
-- It took me half a century to understand how to access those values stored in a data type
-- It's as easy as , e.g. noughts board where board is an instance with Board type
data Board = Board
    { 
        noughts :: [Coordinates],
        crosses :: [Coordinates],
        player :: Player
    }
-- Ruby and his nemesis
-- https://www.colorhexa.com/e0115f
rubyColor = makeColor 0.876 0.067 0.373 1
aquaColor = makeColor 0.067 0.878 0.573 1

-- This method counts the number of occurances of a predicate
count :: (a -> Bool) -> [a] -> Int
count predicate list = length $ filter predicate list

-- If possible adds a new nought/cross to the board
-- This method was mostly copied (except for the checking) from the most important link when I was learning how to make this work
-- Later I figure it out and gonna explain to not just throw here
-- We receive a coordinate to be pushed in the board and the current board
-- If the coordinate is on the crosses list of board coordinates or in the noughts we return the same board, I.e we don't do nothing
-- If the new coord is not in the board (not in the noughts nor in the coordinates)
-- We make a switch-case-haskell-version (from the german SchalterHaskellgehäuseVersion) in the player which is just a syntax sugar (We can write this in other more common ways)
-- If is a Nought b (our board) is the c and the noughts of b (which is a way of saying just noughts b + newNought) and if is a cross we do the same thing but obviously for a cross
-- Also, please note that in the new board we created from the previous one we set the player to be the opposite of the current one
pushToken :: Coordinates -> Board -> Board
pushToken c b
    | elem c (crosses b) || elem c (noughts b) = b
    | otherwise = case player b of
        Nought -> b { noughts = c : noughts b, player = Cross  }
        Cross  -> b { crosses = c : crosses b, player = Nought }

-- You may not believe but this is truly an empty board, no hidden nought
emptyBoard :: Board
emptyBoard = Board [] [] Nought

-- We draw a nought in the screen, the position of it is given by the coordinates transformed to fit perfectly on our grid
drawNought :: Coordinates -> Picture
drawNought (x,y) = color rubyColor (translate  x' y'  (thickCircle radius (radius * 0.3)))
    where
        x' = fromIntegral x * nodeSize
        y' = fromIntegral y * nodeSize
        radius = nodeSize/3
        nodeSize = screenSizef/gridSizef

-- And this one draws a cross (or a 4 vertex version of it which is a square, if haskell is lazy why a haskell programmer can't be?)
drawCross :: Coordinates -> Picture
drawCross (x,y) = color aquaColor (translate  x' y'  (rectangleSolid rectSize rectSize))
    where
        x' = fromIntegral x * nodeSize
        y' = fromIntegral y * nodeSize
        rectSize = (nodeSize/3)*2
        nodeSize = screenSizef/gridSizef

-- Given a list of coordinates returns if we have at least the columns number (default = 3) in any row
row :: Int -> [Coordinates] -> Bool
row columns coords = any (==columns) columnsCount
    where 
        columnsCount = [elemWithColumn c | c <- [-range..range]]
        elemWithColumn col = count (\coord -> snd coord == col) coords
        range = div columns 2
-- Do the exact same thing for a column 
column :: Int -> [Coordinates] -> Bool
column rows coords = any (==rows) rowsCount
    where 
        rowsCount = [elemWithRow r | r <- [-range..range]]
        elemWithRow rw = count (\coord -> fst coord == rw) coords
        range = div rows 2
-- Easy peasy, checks for same x,y coordinates
diag :: Int -> [Coordinates] -> Bool
diag cont coords = (count (\x -> fst x == snd x) coords) == cont

-- This function can tell who is the winner
-- Using maybe which is a I.M.H.O a complex way of saying that a class can have a null value
-- I know this isn't the finest definition but if I knew that before today I would really just see the Maybe as something good and not a monster
-- Now I know
-- The winner can be a nought, a cross or not at all, that's why the maybe winner
evaluateWinner :: Board -> Maybe Player
evaluateWinner board
    | row gridSize (noughts board) || column gridSize (noughts board) || diag gridSize (noughts board) = Just Nought
    | row gridSize (crosses board) || column gridSize (crosses board) || diag gridSize (crosses board) = Just Cross
    | otherwise = Nothing

-- Function that format the win text to be at least presentable
-- Gloss is really bad at texts
-- You can't change the font nor the font size
-- Yes, you can use resize for the size but note that the quality will be compromised anyway
-- And you can't know for sure the size of the font, that's why we have a fontsize approximation to centralized the text
winText :: String -> Picture
winText str = Scale ratio ratio posText
    where
        ratio = 0.4
        posText = Translate xPos yPos text 
        text = Text str
        yPos = screenSizef * 0.8
        xPos = (fromIntegral $ length str)/2 * fontSizeApproximation
        fontSizeApproximation = -70
-- We create a bunch of pictures from the noughts using the drawNought and the crosses using the drawCross
-- We add those pictures with our text and we have our display game
-- The fmap is going to be explained in a different document, spoiler : it yields the same results as map (but I need to study more)
drawBoard :: Board -> Picture
drawBoard board = Pictures $ ns ++ cs ++ [winInfo (evaluateWinner board)]
        where
            cs = fmap (drawNought) $ noughts board
            ns = fmap (drawCross) $ crosses board
            winInfo :: Maybe Player -> Picture
            winInfo player =
                case player of
                    Just Nought -> color rubyColor (winText "Noughts won")
                    Just Cross -> color aquaColor (winText "Crosses won")
                    Nothing -> Blank
-- This is one of the functions I copied and it's actually not great
-- It is what is keeping me from making n-sizeable Tic Tac Toes
-- I will refactorate with my logic soon
checkCoordinate :: Float -> Maybe Int
checkCoordinate f' =
    let k = screenSizef/gridSizef
        f = f' / k
    in (-1)    <$ guard (-1.5 < f && f < -0.5)
    <|> 0    <$ guard (-0.5 < f && f < 0.5)
    <|> 1   <$ guard (0.5  < f && f < 1.5)
-- This was also copied from the most important link but it can't be different since we need the click position information
-- Basically we get an event and try to match with the pattern (EventKey (MouseButton LeftButton) Down _ (x', y'))
-- A event of the type mouse button left click down with the x and y parameters and the board as parameter
-- We get the x and y and check with the checkCoordinate function what is the resulted coordinate
-- If the event is other thing we just return the same state board
-- I will do one Maybe Doc about the return
handleKeys :: Event -> Board -> Board
handleKeys (EventKey (MouseButton LeftButton) Down _ (x', y')) b =
    fromMaybe b $ do
        x <- checkCoordinate x'
        y <- checkCoordinate y'
        return $ pushToken (x, y) b
handleKeys _ b = b
-- The main function uses the gloss to run our game
-- The play function is better suited for games instead of the display one
-- The 1 is the number of updates per second
-- We don't need 60 FPS since it's a turn based game
-- The format is play :: Display (Display Mode) -> Color (BG Color) -> Int (FPS) -> world (Initial state) -> (world -> Picture) (A function to convert world to picture)
-- -> (Event -> world -> world)	(A function to handle individual input events) -> [Float -> world -> world] (Set of functions invoked once per iteration) -> IO()
main :: IO()
main = play window bgColor 1 emptyBoard (drawBoard) handleKeys (flip const)
    where 
        window = InWindow screenName (screenSize,screenSize) (10, 10)
        screenName = "Tic Tac Toe"
        bgColor = makeColor 0.1 0.1 0.1 1
