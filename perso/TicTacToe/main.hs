{- References:
https://codereview.stackexchange.com/questions/68345/tictactoe-in-haskell
https://gist.github.com/nick-paul/6a7df0112fe342ee828c9f6bd44a41ad
https://www.schoolofhaskell.com/user/chad/snippets/a-tic-tac-toe-board
https://stackoverflow.com/questions/35507997/reading-user-mouseclick-position-in-haskells-gloss
https://hackage.haskell.org/package/gloss-1.9.4.1/docs/

-}
import Graphics.Gloss
import Data.Maybe
import Control.Monad
import Control.Applicative
import Graphics.Gloss.Interface.Pure.Game
import Constants
type Coordinates = (Int,Int)
data Player = Nought | Cross

data Board = Board
    { noughts :: [Coordinates],
    crosses :: [Coordinates],
    player :: Player
    }
--https://www.colorhexa.com/e0115f
rubyColor = makeColor 0.876 0.067 0.373 1
aquaColor = makeColor 0.067 0.878 0.573 1

pushToken :: Coordinates -> Board -> Board
pushToken c b = case player b of
  Nought -> b { noughts = c : noughts b, player = Cross  }
  Cross  -> b { crosses = c : crosses b, player = Nought }

emptyBoard :: Board
emptyBoard = Board [] [] Nought
drawNought :: Coordinates -> Picture
drawNought (x,y) = color rubyColor (translate  x' y'  (thickCircle radius (radius * 0.3)))
    where
        x' = fromIntegral x * nodeSize
        y' = fromIntegral y * nodeSize
        radius = nodeSize/3
        nodeSize = screenSizef/gridSizef
drawCross :: Coordinates -> Picture
drawCross (x,y) = color aquaColor (translate  x' y'  (rectangleSolid rectSize rectSize))
    where
        x' = fromIntegral x * nodeSize
        y' = fromIntegral y * nodeSize
        rectSize = (nodeSize/3)*2
        nodeSize = screenSizef/gridSizef
drawBoard :: Board -> Picture
drawBoard board = Pictures $ ns ++ cs
        where
            cs = fmap (drawNought) $ noughts board
            ns = fmap (drawCross) $ crosses board

checkCoordinate :: Float -> Maybe Int
checkCoordinate f' =
    let k = screenSizef/gridSizef
        f = f' / k
    in (-1)    <$ guard (-1.5 < f && f < -0.5)
    <|> 0    <$ guard (-0.5 < f && f < 0.5)
    <|> 1   <$ guard (0.5  < f && f < 1.5)
handleKeys :: Event -> Board -> Board
handleKeys (EventKey (MouseButton LeftButton) Down _ (x', y')) b =
    fromMaybe b $ do
        x <- checkCoordinate x'
        y <- checkCoordinate y'
        return $ pushToken (x, y) b
handleKeys _ b = b
main :: IO()
main = play window bgColor 1 emptyBoard (drawBoard) handleKeys (flip const)
    where 
        window = InWindow screenName (screenSize,screenSize) (10, 10)
        screenName = "Tic Tac Toe"
        bgColor = makeColor 0.15 0.15 0.15 1
