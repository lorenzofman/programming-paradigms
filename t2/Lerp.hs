module Lerp where
    import Colors
    lerp :: Int -> Int -> Float -> Int
    lerp v0 v1 t = v0 + round (t * (fromIntegral(v1 - v0)))

    lerpColor :: RGBColor -> RGBColor -> Float -> RGBColor
    lerpColor (r,g,b) (r',g',b') t = (lerp r r' t,lerp g g' t,lerp b b' t)