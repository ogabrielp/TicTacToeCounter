/* Board.java
 *
 * This is an auxiliary class in order to further increase legibility of
 * the program.
 * I am well aware that some of my notation choices ended up taking more
 * lines of code than it would be necessary. However, I decided to choose
 * a legible code over a compact one.
 */

package com.ogp;

class Board
{
  // The values below are constants used across the program.
  static final int BLANK = 0;
  static final int X = 1;
  static final int O = 2;

  // To avoid random numbers on the code
  private final int ARRAY_LAST_POSITION;
  private final int ARRAY_SIZE = 9;

  // The array below will hold information about the board's values.
  private final int array[];

  /*
   * The Board() constructor is simple and just initiates the array with 0s.
   * It's an array of 9 positions because that's the amount of positions a
   * tic-tac-toe board has.
   *
   * Each position of the array is equivalent to one of the positions of the
   * board, where the first position is equivalent to the upper-left corner
   * of the board, and the last position is equivalent to the lower-right
   * corner.
   *
   * Each group of three subsequent positions in the array are equivalent to
   * a row of the board.
   */

  Board()
  {
    array = new int[ARRAY_SIZE];
    ARRAY_LAST_POSITION = array.length-1;
    reset();
  }

  // The reset method fills the array with zeroes, so it's a blank board.
  void reset()
  {
    for (int i = 0; i < ARRAY_SIZE; i++)
    array[i] = 0;
  }

  /* The increase() and isFinished() methods below are for the current purpose
   * of this class, which is mostly mathematical, and might (and most likely
   * will) be removed on future commits.
   *
   * Since I wanted to figure out the amount of possibilities for the final
   * states of a tic-tac-toe game, I considered ALL possible combinations
   * you could have on the board, including the ones that violate the
   * rules of the game. My intention was to work it down, starting big,
   * and then filter out those who didn't fit the rules.
   *
   * If you think of 0 as blank, 1 as X and 2 as circle, and considering
   * you have 9 spaces to fill, the total amount of possibilities is 3^9
   * (three to the power of nine).
   *
   * What I decided to do was to go through all possibilities, since all of
   * them can be represented as a base-3 number, starting with the very first
   * possibility (000 000 000, imagine each group of three digits as a row)
   * and work it up to the very last possibility, 222 222 222. Again, these
   * are impossible to obtain in a regular game, but I was gonna test all of
   * them and filter out those who infringed the rules.
   */

  /*
   * The increase() method considers the array as a base-3 number and
   * increases it by 1.
   */
  void increase()
  {
    // Increasing the last position of the number, as a simple sum would.
    array[ARRAY_LAST_POSITION]++;

    // Does a reverse check, going through the array starting from the end
    for (int i = ARRAY_LAST_POSITION; i > 0; i--)
    {
      if (array[i] > 2)  // If this position has a value greater than 2
      {
        if (i == 0)      // If it is the first position
          break;        // Breaks because it reached the maximum value
        else            // Otherwise
        {
          array[i] = 0; // Resets this position to 0
          array[i-1]++; // Increases previous position by one
        }
      }
    }
  }

  /*
   * The isFinished() method checks if the array reached its maximum value,
   * 222 222 222.
   *
   * Returns TRUE if it has reached the maximum value, FALSE otherwise.
   */
  boolean isFinished()
  {
    // Goes through the array
    for (int i = 0; i < ARRAY_SIZE; i++)
    {
      if (array[i] != 2)  // If it finds some value different of 2
        return false;    // It has not reached the maximum value
    }

    return true;         // All positions have the value 2, so it has
  }                      // reached the maximum value.

  /*
   * The toString() method overrides the java.lang.Object.toString() method
   * and generates a string of 9 characters representing the board state.
   *
   * As stated before, the board will be scanned by rows, from left to
   * right, top to bottom, starting at the upper-left corner and ending at
   * the lower-right corner. To each position, it will be assigned a value
   * ranging from 0 to 2, according to that position's state.
   *
   * The final value will be output as a string.
   *
   * This method is most likely gonna be used for debugging purposes only.
   */

  @Override
  public String toString()
  {
    String output = "";         // Initializes the return variable as a
                                // blank string

    for (int i = 0; i < 9; i++)  // Goes through the array
      output += array[i];       // Adds that position to the string

    return output;              // Returns the string
  }

  /*
   * The set() method changes the current state of the board based on a
   * string passed as a parameter.
   */

  void set(String input)
  {
    for (int i = 0; i < 9; i++)    // Goes through the array
    {
      // Gets the numeric velue of a character of the string and stores
      // said value in the corresponding position of the array.
      array[i] = Character.getNumericValue(input.charAt(i));

      /* Sanity-checking the input; positions of the array must not have values
       * greater than 2 since such value has no equivalent on the board.
       * It's also necessary to check for negative values, because the
       * getNumericValue() method does not throw exceptions when it has to
       * handle inputs with non-numeric values; instead, it returns a negative
       * number (-1 or -2).
       */
      if (array[i] > 2 || array[i] < 0)
      {
        reset();
        System.out.println("Your input for the board state was invalid. Board" +
        " state was reset.");
        break;
      }
    }
  }

  /*
   * The visualize() method is a simple method that converts the array
   * information into an actual tic-tac-toe board.
   */
  String visualize()
  {
    String output = "|";                
    for (int i = 0; i < 9; i++)         //Goes through the array
    {
      if (i % 3 == 0 && i != 0)         //Every three positions
      {
        output += "\n|";                //Inserts a line break
      }

      switch(array[i])
      {
        case 0:   output += " |";break;
        case 1:   output += "X|";break;
        case 2:   output += "O|";break;
        default:  output += "?|";break;
      }
    }

    return output;
  }
}
