    module Palette where
        import Colors
        rgbPalette :: Int -> [RGBColor]
        rgbPalette n = take n $ cycle [(255,0,0),(0,255,0),(0,0,255)]

        greenPalette :: Int -> [RGBColor]
        greenPalette n = [(0,80+i*10,0) | i <- [0..n] ]

        colorWheel :: Int -> Float -> Float -> [RGBColor]
        colorWheel n s v = map convertHSV2RGB [(h i,s,v) | i <- [0..n] ] where
            h i = quot (i * 360) n