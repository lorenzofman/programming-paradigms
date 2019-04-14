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
        palette = (tones (222, 171, 33)) (lines*columns)
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
        positions = pattern2 n bigRadius centerX centerY 0
        palette = colorWheel n saturation vibrance
        saturation = 1
        vibrance = 1
        smallRadius = 32
        bigRadius = 128
        n = 32
        centerX = screenWidth/2
        centerY = screenHeight/2
        (width,height) = (screenWidth,screenHeight) -- width,height da imagem SVG

case3 :: IO ()
case3 = do
  writeFile "case3.svg" $ svgstrs
  where svgstrs = svgBegin width height ++ svgfigs ++ svgEnd
        svgfigs = svgShapes svgCircle circles (map svgStyle palette)
        circles = createCircles' positions circleRadius
        positions = pattern3 lines columns n drawRadius offset 
        palette = concat $ take (lines*columns) (repeat (colorWheel n 1 1))
        n = 3
        lines = 3
        columns = 3
        circleRadius = 32
        drawRadius = 32
        offset = 128
        rectWidth = 20
        rectHeight = 20
        (width,height) = (screenWidth,screenHeight) -- width,height da imagem SVG
case4 :: IO ()
case4 = do
  writeFile "case4.svg" $ svgstrs
  where svgstrs = svgBegin width height ++ svgfigs ++ svgEnd
        svgfigs = svgShapes svgCircle circles (map svgStyle palette)
        circles = createCircles' positions circleRadius
        positions = centralizePoints (pattern4 amplitude period n m yOffset) ((width - period)/2,height/2) 
        m = 3
        yOffset = 64
        palette = reverse ((shades (255,0,0) n) ++ (shades (0,255,0) n) ++ (shades (0,0,255) n))
        n = 16
        amplitude = 64
        period = 256
        circleRadius = 32
        (width,height) = (screenWidth,screenHeight) -- width,height da imagem SVG
caseX :: IO ()
caseX = do
  putStr("Number of shapes: ")
  n <- readLn
  writeFile "caseX.svg" $ svgstrs n
  putStrLn("SVG Created and saved to caseX.svg")
  where svgstrs n = svgBegin width height ++ (svgfigs n) ++ svgEnd
        svgfigs n = svgShapes svgCircle (circles n) (map svgStyle (palette n))
        circles n = createCircles' (positions n) circleRadius
        positions n = centralizePoints (pattern4 amplitude period n m yOffset) ((width - period)/2,height/2) 
        palette n = rgbPalette n
        m = 3
        yOffset = 100
        amplitude = 64
        period = 256
        circleRadius = 2
        (width,height) = (screenWidth,screenHeight) -- width,height da imagem SVG