/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.view;

/**
 *
 * @author Yvette
 */
public class Gameboard {
    
    /**
     * This method prints the board
     * @param board 
     */
    public void Board (char[][] board)
    {        
        for(char[] row : board)
            {
                for(char col : row)
                {
                    System.out.print(col);
                }
                System.out.println();
            }
    }
    
}
