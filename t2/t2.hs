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
        rectangles = pattern1 nrectangles
        palette = greenPalette nrectangles
        nrectangles = 30
        (width,height) = (1500,500) -- width,height da imagem SVG