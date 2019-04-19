{- References:
https://codereview.stackexchange.com/questions/68345/tictactoe-in-haskell
https://gist.github.com/nick-paul/6a7df0112fe342ee828c9f6bd44a41ad
https://www.schoolofhaskell.com/user/chad/snippets/a-tic-tac-toe-board
https://stackoverflow.com/questions/35507997/reading-user-mouseclick-position-in-haskells-gloss
https://hackage.haskell.org/package/gloss-1.9.4.1/docs/

-}
import Graphics.Gloss
import Constants
type Coordinates = (Int,Int)
data Player = Nought | Cross

data Board = Board
{
    noughts :: [Coordinates],
    crosses :: [Coordinates],
    player :: Player
}
--https://www.colorhexa.com/e0115f
rubyColor = makeColor 0.876 0.067 0.373 1
aquaColor = makeColor 0.067 0.878 0.573 1

emptyBoard :: Board
emptyBoard = Board [] [] Nought
drawNought :: Coordinates -> Picture
drawNought (x,y) = color $ crossColor translate x' y' $ thickCircle radius (radius * 0.3)
    where
        x' = x * nodeSize
        y' = y * nodeSize
        crossColor = rubyColor
        radius = nodeSize/3
        nodeSize = screenSize/gridSize
drawCross :: Coordinates -> Picture
drawCross (x,y) = color 
main = display (InWindow screenName screenSize screenSize (10, 10)) bgColor pictureList)
