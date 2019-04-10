import SVGShapes
import SVGEssentials
import Patterns
import Palette
import Constants
import Shapes
import Colors
import Utils
import Text.Printf

-------------------------------------------------------------------------------
-- Função principal que gera arquivo com imagem SVG
-------------------------------------------------------------------------------

case1 :: IO ()
case1 = do
  writeFile "case1.svg" $ svgstrs
  where svgstrs = svgBegin width height ++ svgfigs ++ svgEnd
        svgfigs = svgShapes svgRectangle rectangles (map svgStyle palette)
        rectangles = createRects' positions (rectWidth,rectHeight)
        positions = pattern1 columns lines rectWidth rectHeight gap
        palette = greenPalette (lines*columns)
        lines = 10
        columns = 5
        gap = 10
        rectWidth = 20
        rectHeight = 20
        (width,height) = (screenWidth,screenHeight) -- width,height da imagem SVG


case2 :: IO ()
case2 = do
  writeFile "case2.svg" $ svgstrs
  where svgstrs = svgBegin width height ++ svgfigs ++ svgEnd
        --svgfigs = svgShapes svgRectangle rectangles (map svgStyle palette)
        --rectangles = createRects' positions (rectWidth,rectHeight)
        svgfigs = svgShapes svgCircle circles (map svgStyle palette)
        circles = createCircles' positions smallRadius
        positions = pattern2 n bigRadius centerX centerY
        palette = greenPalette n
        smallRadius = 32
        bigRadius = 256
        n = 16
        centerX = screenWidth/2
        centerY = screenHeight/2
        (width,height) = (screenWidth,screenHeight) -- width,height da imagem SVG

case3 :: IO ()
case3 = do
  writeFile "case3.svg" $ svgstrs
  where svgstrs = svgBegin width height ++ svgfigs ++ svgEnd
        svgfigs = svgShapes svgCircle circles (map svgStyle palette)
        circles = createCircles' positions circleRadius
        positions = pattern3 lines columns circleRadius drawRadius offset 
        palette = greenPalette n
        n = 3
        lines = 3
        columns = 2
        circleRadius = 20
        drawRadius = 40
        offset = 100
        rectWidth = 20
        rectHeight = 20
        (width,height) = (screenWidth,screenHeight) -- width,height da imagem SVG
case4 :: IO ()
case4 = do
  writeFile "case4.svg" $ svgstrs
  where svgstrs = svgBegin width height ++ svgfigs ++ svgEnd
        svgfigs = svgShapes svgCircle circles (map svgStyle palette)
        circles = createCircles' positions circleRadius
        positions = centralizePoints (pattern4 amplitude period n) ((width - period)/2,height/2) 
        palette = greenPalette n
        n = 64
        amplitude = 64
        period = 256
        circleRadius = 2
        (width,height) = (screenWidth,screenHeight) -- width,height da imagem SVG