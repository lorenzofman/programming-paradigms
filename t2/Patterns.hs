module Patterns where
import Constants
import Types
pattern1 :: Int -> Int -> Float -> Float -> Float -> [Rectangle]
pattern1 n m width height offset = [((x i, y j), (width,height)) | j <- columnIt, i <- lineIt]
    where
        x i = i*(width+offset)
        y j = j*(height+offset)
        lineIt = [0..fromIntegral (n-1)]
        columnIt = [0..fromIntegral (m-1)]

pattern2 :: Int -> Float -> Float -> Float -> [Rectangle]
pattern2 n width height radius = [((x i,y i),(width,height)) | i <- [0 .. fromIntegral n]]
    where 
        x i = ((cossine i ) * radius) + screenWidth/2
        y i = ((sine i ) * radius )+ screenHeight/2
        cossine i = cos(2 * pi*i/floatN)
        sine i = sin(2 * pi*i/floatN)
        floatN = fromIntegral n