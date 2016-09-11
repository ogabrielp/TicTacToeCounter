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
      count++;
      b.increase();
    }

    // This last count is here because the while loop does not count the last
    // value (222 222 222) since it does not repeat the loop once b reaches
    // the maximum value.
    count++;

    // Output
    System.out.println(count);

    //Testing the new methods: this is a valid input and should work
    b.set("102020101");
    System.out.println("Board: \n"+b.visualize());

    // This is not because it has a 3 in it
    b.set("130000000");

    // This is not because it has the letter O in it
    b.set("000000O00");
  }
}
