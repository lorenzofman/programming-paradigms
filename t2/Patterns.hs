module Patterns where
import Types
pattern1 :: Int -> Int -> Float -> Float -> Float -> [Rectangle]
pattern1 n m width height offset = [(((i*(width+offset), (j*(height+offset))), (width,height) )) | i <- [0..fromIntegral (n-1)], j <- [0..fromIntegral (m-1)]]