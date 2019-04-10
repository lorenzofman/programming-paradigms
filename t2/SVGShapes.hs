module SVGShapes where
    import Text.Printf
    import Types
    -- Gera string representando retângulo SVG 
    -- dadas coordenadas e dimensoes do retângulo e uma string com atributos de estilo
    svgRectangle :: Rectangle -> String -> String 
    svgRectangle ((x,y),(w,h)) style = printf "<rect x=\"%.3f\" y=\"%.3f\" width=\"%.2f\" height=\"%.2f\" style=\"%s\" />\n" x y w h style

    -- Gera string representando circulo SVG 
    -- dadas coordenadas e dimensoes do retângulo e uma string com atributos de estilo
    svgCircle :: Circle -> String -> String 
    svgCircle ((x,y),r) style = printf "<circle cx=\"%.3f\" cy=\"%.3f\" r=\"%.2f\" style=\"%s\" />\n" x y r style


    -- Gera strings SVG para uma dada lista de figuras e seus atributos de estilo
    -- Recebe uma funcao geradora de strings SVG, uma lista de círculos/retângulos e strings de estilo
    svgShapes :: (a -> String -> String) -> [a] -> [String] -> String
    svgShapes func elements styles = concat $ zipWith func elements styles