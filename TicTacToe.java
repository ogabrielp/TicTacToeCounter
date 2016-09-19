package com.ogp;

public class TicTacToe
{
  public static void main (String args[])
  {
    // Main variables
    Board b = new Board();
    int count = 0;

    // While it doesn't reach maximum value
    while (!b.isFinished())
    {
      // Count and increase the value in b
      if (b.isValidGame())
        count++;
      b.increase();
    }

    System.out.println(count);
  }
}
