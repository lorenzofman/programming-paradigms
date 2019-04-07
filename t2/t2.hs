import SVGShapes
import SVGEssentials
import Patterns
import Palette
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
        (width,height) = (1500,500) -- width,height da imagem SVG