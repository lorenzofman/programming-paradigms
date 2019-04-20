# Haskell Tic Tac Toe Game

## How to run:

###### Installing gloss:

`cabal update`

`cabal install gloss`

###### Loading interactive mode

`ghci`

###### Loading Tic Tac Toe game

`prelude> :load main.hs`

###### Playing game

`prelude> main`

###### (Alt) Compiling main:

`ghc -o main main.hs`

References:

Most ~~copied~~ important link: https://stackoverflow.com/questions/35507997/reading-user-mouseclick-position-in-haskells-gloss

https://codereview.stackexchange.com/questions/68345/tictactoe-in-haskell
https://gist.github.com/nick-paul/6a7df0112fe342ee828c9f6bd44a41ad
https://www.schoolofhaskell.com/user/chad/snippets/a-tic-tac-toe-board

https://hackage.haskell.org/package/gloss-1.9.4.1/docs/

## Used packages:

### Gloss

(Painless 2D vector graphics, animations and simulations.)

Link: <https://hackage.haskell.org/package/gloss-1.9.4.1> 

## Purpose

The purpose is to recreate a simple game in a functional language to help my understanding about the functional paradigm. Also learn how to configure a different API and use it in Haskell

## About the Code

You will find information about how the program work inside the `main.hs` file comments. There I detailed described what I have to do and where I searched for how to do it

## Next steps

- Block interaction when any user win
- Generalize functions to allow n-grids
- Create a real cross instead of a square