module Patterns where
import Constants
import Types
import Utils
pattern1 :: Int -> Int -> Float -> Float -> Float -> [Point]
pattern1 n m width height offset = [((x i, y j)) | j <- columnIt, i <- lineIt]
    where
        x i = i*(width+offset)
        y j = j*(height+offset)
        lineIt = [0..fromIntegral (n-1)]
        columnIt = [0..fromIntegral (m-1)]

pattern2 :: Int -> Float -> Float -> Float -> Float -> [Point]
pattern2 n radius centerX centerY angOffset = [(x i, y i) | i <- [0 .. fromIntegral n]]
    where 
        x i = ((cossine i ) * radius) + centerX
        y i = ((sine i ) * radius )+ centerY
        cossine i = cos(2 * pi*i/floatN + angOffset)
        sine i = sin(2 * pi*i/floatN + angOffset)
        floatN = fromIntegral n
pattern3 :: Int -> Int -> Int -> Float -> Float -> [Point]
pattern3 lines columns circlesPerBatch drawRadius offset = patternList
    where
        patternList = concat (map points positions)
        positions = [(x i, y j) | i <- [1..fromIntegral columns], j <- [1..fromIntegral lines]]
        x i = (i - ((fromIntegral columns)/2)) * offset
        y j = (j - ((fromIntegral lines)/2)) * offset
        points (x,y) = centralizePoints (pattern2 circlesPerBatch drawRadius x y (pi/6)) (cx,cy)
        (cx,cy) = (screenWidth/2,screenHeight/2)
pattern4 :: Float -> Float -> Int -> Int -> Float -> [Point]
pattern4 amplitude period n m yOffset = [(x i ,y i j) | j <- [0..fromIntegral m-1],i <- [0..fromIntegral n]]
    where 
        y i j = amplitude * sin(pi * 2 * i/fromIntegral n) + yOffset * (j - fromIntegral m/2)
        x i = (i/fromIntegral n) * period

