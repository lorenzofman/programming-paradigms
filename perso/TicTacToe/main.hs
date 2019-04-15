import Graphics.Gloss
import Constants
main = display (InWindow screenName screenSize (10, 10)) bgColor pictureList
    where
        screenName = "Tic Tac Toe"
        pictureList = Pictures [redCircle]
        bgColor = makeColor 0.15 0.15 0.15 1
        redCircle = createO oColor
        oColor = makeColor 0.5 0.5 0.5 1
createO color = Color color (ThickCircle radius (radius * 0.3))
    where 
        radius = (minScreen - offset)/3
        minScreen :: Float
        minScreen = min screenHeightf screenWidthf
        offset = 64