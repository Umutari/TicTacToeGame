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
    public void Board (String[][] board)
    {        
        System.out.println("----+----+---");
        for(int i=0; i<3; i++)
        {
            System.out.print("| ");
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n----+----+---");
        }
    }
    
}
