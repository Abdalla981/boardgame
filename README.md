# Connect 4 Board Game

## Description

A simple game where two players use red and blue pieces to try and connect 4 pieces together.


## Rules

- Each player use the same color.
- Pieces sink down upon clicking on any column.
- Pieces are considered connected if they are next to each other horizontally, vertically or diagonaly.
- Whoever connects 4 pieces first wins.

## How to start the game

1. Download the boardgame folder.
2. Open the terminal and navigate to the folder containing the boardgame folder. (Be outside boardgame folder)
3. Type this command: javac boardgame/Connect4.java
4. Then, type this command: java boardgame/Connect4


## Technical Description

The game is written in Java by implementing 4 classes together and use inheritance to acquire functions from parent class.
BoardGame class is used to define the outline of the game, while TicTacToe and TurnBasedGame classes are used as they provide very relevent gaming style to Connect 4 game.
The Connect4 class is then used to add the special feature of the game while implementing the other classes.
The Connect4 class is the main class that runs the game.
