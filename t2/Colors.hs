module Colors where
    type RGBColor = (Int,Int,Int)
    type HSVColor = (Int,Int,Int)

    convertRGB2HSL :: RGBColor -> HSVColor
    convertRGB2HSL = undefined

    convertHSL2RGB :: HSVColor -> RGBColor
    convertHSL2RGB = undefined