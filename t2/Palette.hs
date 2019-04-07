    module Palette where
    rgbPalette :: Int -> [(Int,Int,Int)]
    rgbPalette n = take n $ cycle [(255,0,0),(0,255,0),(0,0,255)]

    greenPalette :: Int -> [(Int,Int,Int)]
    greenPalette n = [(0,80+i*10,0) | i <- [0..n] ]