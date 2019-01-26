/**
 * CSCI1130 Assignment 2 BaseConversion
 *
 * I declare that the assignment here submitted is original
 * except for source material explicitly acknowledged,
 * and that the same or closely related material has not been
 * previously submitted for another course.
 * I also acknowledge that I am aware of university policy and
 * regulations on honesty in academic work, and of the disciplinary
 * guidelines and procedures applicable to breaches of such
 * policy and regulations, as contained in the website.
 *
 * University Guideline on Academic Honesty:
 *   http://www.cuhk.edu.hk/policy/academichonesty
 * Faculty of Engineering Guidelines to Academic Honesty:
 *   https://www.erg.cuhk.edu.hk/erg/AcademicHonesty
 *
 * Student Name: Abdalla Moustafa
 * Student ID  : 1155099069
 * Date        : 5/12/2018
 */
package boardgame;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Connect4 extends TurnBasedGame
{

  String winner;

  public Connect4 ()
  {
    super (7, 6, "RED", "BLUE");
    this.setTitle ("Connect 4");
  }

  @Override protected void initGame ()
  {
    for (int y = 0; y < yCount; y++)
      {
        for (int x = 0; x < xCount; x++)
          {
            pieces[x][y].setText (" ");
          }
      }
  }

  @Override protected void gameAction (JButton triggeredButton)
  {
    String[]coord = triggeredButton.getActionCommand ().split (",");
    int x = Integer.parseInt (coord[0]);
    int y = 0;

    while (y < yCount && pieces[x][y].getText ().equals (" "))
      {
        y++;
      }
    y--;
    if (y > -1)
      {
        addLineToOutput (currentPlayer + " piece at column " + x);
        pieces[x][y].setText (currentPlayer);
        pieces[x][y].setBackground (currentPlayer ==
                                    "RED" ? Color.RED : Color.BLUE);
        pieces[x][y].setOpaque (true);

        checkEndGame (x, y);

        if (gameEnded)
          {
            addLineToOutput ("Game ended!");
            JOptionPane.showMessageDialog (null, "Game ended!");
            System.exit (0);
          }

        changeTurn ();
      }
    else
      {
        addLineToOutput ("Invalid move!");
      }
  }

  @Override protected boolean checkEndGame (int buttonX, int buttonY)
  {
    if (hasWinner (buttonX, buttonY))
      {
        gameEnded = true;
        addLineToOutput ("Winner is " + winner + "!");
      }
    else if (turn == xCount * yCount)
      {
        gameEnded = true;
        addLineToOutput ("Draw game!");
      }
    return gameEnded;
  }

  protected boolean hasWinner (int x, int y)
  {
    boolean haswinner = false;

    for (int i = y; i < yCount - 3 && y < yCount - 3; i++)
      {
        if (pieces[x][i].getText ().equals (currentPlayer)
            && pieces[x][i + 1].getText ().equals (currentPlayer)
            && pieces[x][i + 2].getText ().equals (currentPlayer)
            && pieces[x][i + 3].getText ().equals (currentPlayer))
          {
            winner = currentPlayer;
            pieces[x][i].setBackground (Color.YELLOW);
            pieces[x][i + 1].setBackground (Color.YELLOW);
            pieces[x][i + 2].setBackground (Color.YELLOW);
            pieces[x][i + 3].setBackground (Color.YELLOW);
            pieces[x][i].setOpaque (true);
            pieces[x][i + 1].setOpaque (true);
            pieces[x][i + 2].setOpaque (true);
            pieces[x][i + 3].setOpaque (true);
            haswinner = true;
          }
      }
    for (int i = 0; i < xCount - 3; i++)
      {
        if (pieces[i][y].getText ().equals (currentPlayer)
            && pieces[i + 1][y].getText ().equals (currentPlayer)
            && pieces[i + 2][y].getText ().equals (currentPlayer)
            && pieces[i + 3][y].getText ().equals (currentPlayer))
          {
            winner = currentPlayer;
            pieces[i][y].setBackground (Color.YELLOW);
            pieces[i + 1][y].setBackground (Color.YELLOW);
            pieces[i + 2][y].setBackground (Color.YELLOW);
            pieces[i + 3][y].setBackground (Color.YELLOW);
            pieces[i][y].setOpaque (true);
            pieces[i + 1][y].setOpaque (true);
            pieces[i + 2][y].setOpaque (true);
            pieces[i + 3][y].setOpaque (true);
            haswinner = true;
          }
      }
    
    for (int i = 0; i < 4; i++)
      {
        for (int j = 0; j < 3; j++)
          {
            if (pieces[i][j].getText ().equals (currentPlayer)
                && pieces[i + 1][j + 1].getText ().equals (currentPlayer)
                && pieces[i + 2][j + 2].getText ().equals (currentPlayer)
                && pieces[i + 3][j + 3].getText ().equals (currentPlayer))
              {
                winner = currentPlayer;
                pieces[i][j].setBackground (Color.YELLOW);
                pieces[i + 1][j + 1].setBackground (Color.YELLOW);
                pieces[i + 2][j + 2].setBackground (Color.YELLOW);
                pieces[i + 3][j + 3].setBackground (Color.YELLOW);
                pieces[i][j].setOpaque (true);
                pieces[i + 1][j + 1].setOpaque (true);
                pieces[i + 2][j + 2].setOpaque (true);
                pieces[i + 3][j + 3].setOpaque (true);
                haswinner = true;
              }
          }
      }
    for (int i = 3; i < xCount; i++)
      {
        for (int j = 0; j < 3; j++)
          {
            if (pieces[i][j].getText ().equals (currentPlayer)
                && pieces[i - 1][j + 1].getText ().equals (currentPlayer)
                && pieces[i - 2][j + 2].getText ().equals (currentPlayer)
                && pieces[i - 3][j + 3].getText ().equals (currentPlayer))
              {
                winner = currentPlayer;
                pieces[i][j].setBackground (Color.YELLOW);
                pieces[i - 1][j + 1].setBackground (Color.YELLOW);
                pieces[i - 2][j + 2].setBackground (Color.YELLOW);
                pieces[i - 3][j + 3].setBackground (Color.YELLOW);
                pieces[i][j].setOpaque (true);
                pieces[i - 1][j + 1].setOpaque (true);
                pieces[i - 2][j + 2].setOpaque (true);
                pieces[i - 3][j + 3].setOpaque (true);
                haswinner = true;
              }
          }
      }

    return haswinner;
  }

  public static void main (String[]args)
  {
    Connect4 game = new Connect4 ();
    game.setLocation (400, 200);
    game.verbose = false;
  }
}