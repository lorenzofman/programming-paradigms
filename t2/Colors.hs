module Colors where
    import Data.Fixed
    type RGBColor = (Int,Int,Int)
    type HSVColor = (Int,Float,Float)

    --https://www.rapidtables.com/convert/color/hsv-to-rgb.html
    convertHSV2RGB :: HSVColor -> RGBColor
    convertHSV2RGB (h,s,v) = (round r,round g,round b) where
        r = (r' + m) * 255
        g = (g' + m) * 255
        b = (b' + m) * 255
        m = v - c
        c = v * s
        (r',g',b') = convertHSV2RGBAux (h,s,v)
    convertHSV2RGBAux :: HSVColor -> (Float,Float,Float)
    convertHSV2RGBAux (h,s,v)
        | h >= 000  && h < 060 = (c,x,0)
        | h >= 060  && h < 120 = (x,c,0)
        | h >= 120  && h < 180 = (0,c,x)
        | h >= 180  && h < 240 = (0,x,c)
        | h >= 240  && h < 300 = (x,0,c)
        | otherwise = (c,0,x) where
            c = v * s
            x = c * (1 - y)
            y = abs (z - 1)
            z = mod' w 2.0
            w = (fromIntegral h)/ 60.0
    rgb_black :: RGBColor
    rgb_black = (000,000,000)
    rgb_white :: RGBColor
    rgb_white = (255,255,255)
    rgb_grey :: RGBColor
    rgb_grey = (128,128,128)