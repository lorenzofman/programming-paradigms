module Patterns where
import Constants
import Types
pattern1 :: Int -> Int -> Float -> Float -> Float -> [Point]
pattern1 n m width height offset = [((x i, y j)) | j <- columnIt, i <- lineIt]
    where
        x i = i*(width+offset)
        y j = j*(height+offset)
        lineIt = [0..fromIntegral (n-1)]
        columnIt = [0..fromIntegral (m-1)]

pattern2 :: Int -> Float -> Float -> Float -> [Point]
pattern2 n radius centerX centerY= [(x i,y i) | i <- [0 .. fromIntegral n]]
    where 
        x i = ((cossine i ) * radius) + centerX
        y i = ((sine i ) * radius )+ centerY
        cossine i = cos(2 * pi*i/floatN)
        sine i = sin(2 * pi*i/floatN)
        floatN = fromIntegral n
pattern3 :: Int -> Int -> Float -> Float -> Float -> [Point]
pattern3 = undefined
--pattern3 lines columns circleRadius drawRadius offset = [(x idx,y idx,circleRadius) | i <- [0 ..lines],j <- [0..columns], k <- [0..3]]
--pattern3 lines columns circleRadius drawRadius offset = concat [pattern2 3 100 100 30 (x i) (y j) | i <- [0..fromIntegral lines], j <- [0..fromIntegral columns] ]
--   where
--        x i = i * offset
--        y j = j * offset
pattern4 :: Float -> Float -> Int -> [Point]
pattern4 amplitude period n = [(x i ,y i) | i <- [0..fromIntegral n]]
    where 
        y i = amplitude * sin(pi * 2 * i/fromIntegral n)
        x i = (i/fromIntegral n) * period

