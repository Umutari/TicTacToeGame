/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.model;

import java.util.Scanner;

/**
 *
 * @author Yvette
 */
public class TicTacToeModel {
    
    /**
     * This method returns the character of the board (How it looks like)
     * @return 
     */
    public char[][] playBoard()
    {
        char [][] board={{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};
        return board;
    }
    
    /**
     * This method initializes the board with the character X and O
     * @param pos
     * @param user
     * @return 
     */
    public char initBoard(int pos, String user)
    {
        char [][] board={{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};
        
        char playerSymbol=' ';
        if(user.equals("player"))
        {
            playerSymbol='X';
        }
        else if(user.equals("cpu"))
        {
            playerSymbol='O'; 
        }
        
        switch(pos)
        {
            case 1:
                return(board[0][0]=playerSymbol);
//                break;
            case 2:
                board[0][2]=playerSymbol;
                break;
            case 3:
                this.playBoard()[0][4]=playerSymbol;
                break;
            case 4:
                this.playBoard()[2][0]=playerSymbol;
                break;
            case 5:
                this.playBoard()[2][2]=playerSymbol;
                break;
            case 6:
                this.playBoard()[2][4]=playerSymbol;
                break;
            case 7:
                this.playBoard()[4][0]=playerSymbol;
                break;
            case 8:
                this.playBoard()[4][2]=playerSymbol;
                break;
            case 9:
                this.playBoard()[4][4]=playerSymbol;
                break;
            default:
                break;
        }
        return 1;
    }
    
    public int charPlacement()
    {
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter your position from 1 - 9");
        int placement=scan.nextInt();
        return placement;
        
    }
}
