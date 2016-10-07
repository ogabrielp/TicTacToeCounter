###**Tic Tac Toe Counter** is an experiment in combinatorics/discrete math. It is an algorithm developed to count the amount of possible valid outcomes for a Tic Tac Toe game.

The algorithm works by generating ALL possible states for the board at the end of a game - including surreal cases, like the board being completely filled with Xs, for example. Starting from there, the algorithm tests every board against a set of criteria. 

Those criteria are:

1. The absolute value of the difference between the amount of Xs and Os must be either 1 (if the starting player won) or 0 (if the other player did);
2. If there is any empty space on the board, someone must've won. Otherwise, the game is not finished;
3. Only one of the players may have won;
4. No player may have won multiple times in the same board (say, a row and a column filled with Xs).

Every board can be (and is) represented as a 9-digit base 3 number, where 0 means an empty space, 1 means X and 2 means O. By starting with 000 000 000 and going all the way up to 222 222 222 - where each group of 3 digits represent a row of the board - we can generate all mathematically possible board states (even the ones that are not *logically* possible, like the board-filled-with-Xs example).

The algorithm's core method is `isValidGame()`, which lies within the `Board` class. This is the method responsible for testing a particular board against the aforementioned set of criteria. The `TicTacToe` class is responsible merely for incrementing the value of the 9-digit number that represents the board and incrementing a counter variable if the corresponding board is a valid game.

Further information is presented within the `Board.java` file; every method has been meticulously commented to explain the general behavior and purpose of every method.
