module Shapes where
import Types
createRects :: [Point] -> [Point] -> [Rectangle]
createRects positions rectSizes = zip positions rectSizes

createRects' :: [Point] -> Point -> [Rectangle]
createRects' positions rectSize = createRects positions homogeneousList
    where
        homogeneousList = take n (repeat rectSize)
        n = length positions
createCircles :: [Point] -> [Float] -> [Circle]
createCircles positions radius = zip positions radius

createCircles' :: [Point] -> Float -> [Circle]
createCircles' positions radius = createCircles positions homogeneousList
    where
        homogeneousList = take n (repeat radius)
        n = length positions