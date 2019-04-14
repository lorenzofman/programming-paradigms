    module Palette where
        import Lerp
        import Colors
        rgbPalette :: Int -> [RGBColor]
        rgbPalette n = take n $ cycle [(255,0,0),(0,255,0),(0,0,255)]

        greenPalette :: Int -> [RGBColor]
        greenPalette n = [(0,80+i*10,0) | i <- [0..n] ]

        colorWheel :: Int -> Float -> Float -> [RGBColor]
        colorWheel n s v = map convertHSV2RGB [(h i,s,v) | i <- [0..n] ] where
            h i = quot (i * 360) n
            
        
        --https://www.sumydesigns.com/difference-tints-tones-shades/
        shades :: RGBColor -> Int -> [RGBColor]
        shades (r,g,b) n = [lerpColor (r,g,b) rgb_black i | i <- [0,1/fromIntegral n..fromIntegral 1]]

        tints :: RGBColor -> Int -> [RGBColor]
        tints (r,g,b) n = [lerpColor (r,g,b) rgb_white i | i <- [0,1/fromIntegral n..fromIntegral 1]]

        tones :: RGBColor -> Int -> [RGBColor]
        tones (r,g,b) n = [lerpColor (r,g,b) rgb_grey i | i <- [0,1/fromIntegral n..fromIntegral 1]]


