import SVGShapes
import SVGEssentials
import Patterns
import Palette
import Constants
import Shapes
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
        svgfigs = svgShapes svgRectangle rectangles (map svgStyle palette)
        rectangles = createRects' positions (rectWidth,rectHeight)
        positions = pattern2 n rectWidth rectHeight radius centerX centerY
        palette = greenPalette n
        radius = 256
        n = 16
        rectWidth = 20
        rectHeight = 20
        centerX = screenWidth/2
        centerY = screenHeight/2
        (width,height) = (screenWidth,screenHeight) -- width,height da imagem SVG

case3 :: IO ()
case3 = do
  writeFile "case3.svg" $ svgstrs
  where svgstrs = svgBegin width height ++ svgfigs ++ svgEnd
        svgfigs = svgShapes svgRectangle rectangles (map svgStyle palette)
        rectangles = createRects' positions (rectWidth,rectHeight)
        positions = pattern3 lines columns circleRadius drawRadius offset 
        palette = greenPalette n
        n = 3
        lines = 3
        columns = 2
        circleRadius = 20
        drawRadius = 40
        offset = 20
        rectWidth = 20
        rectHeight = 20
        (width,height) = (screenWidth,screenHeight) -- width,height da imagem SVG