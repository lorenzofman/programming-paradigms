import SVGShapes
import SVGEssentials
import Patterns
import Palette
import Constants
import Text.Printf

-------------------------------------------------------------------------------
-- Função principal que gera arquivo com imagem SVG
-------------------------------------------------------------------------------

case1 :: IO ()
case1 = do
  writeFile "case1.svg" $ svgstrs
  where svgstrs = svgBegin width height ++ svgfigs ++ svgEnd
        svgfigs = svgShapes svgRectangle rectangles (map svgStyle palette)
        rectangles = pattern1 columns lines rectWidth rectHeight gap
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
        rectangles = pattern2 n rectWidth rectHeight radius
        palette = greenPalette n
        radius = 256
        n = 16
        rectWidth = 20
        rectHeight = 20
        (width,height) = (screenWidth,screenHeight) -- width,height da imagem SVG