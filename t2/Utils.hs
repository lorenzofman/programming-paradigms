module Utils where
    import Types
    centralizePoints :: [Point] -> Point -> [Point]
    centralizePoints allPoints offset = map (sumPoint offset) allPoints 

    sumPoint :: Point -> Point -> Point
    sumPoint (x1,y1) (x2,y2) = (x1+x2,y1+y2)