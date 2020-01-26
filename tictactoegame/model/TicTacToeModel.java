/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.model;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Yvette
 */
public class TicTacToeModel {
    
    char[][] board={{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};
    
    /**
     * This method returns the character of the board (How it looks like)
     * @return 
     */
    public char[][] drawBoard()
    {
        return this.board;
    }
    
    /**
     * This method allow the Human Player to play
     * @param board
     * @param pos
     * @param user
     * @return 
     */
    public char[][] initBoard(char[][]board,int pos, String user)
    {
        char playerSymbol=' ';
        switch (user) {
            case "player":
                playerSymbol='X';
                break;
            case "computer":
                playerSymbol='O';
                break; 
        }
        board=this.board;
        switch(pos)
        {
            case 1:
                board[0][0]=playerSymbol;
                break;
            case 2:
                board[0][2]=playerSymbol;
                break;
            case 3:
                board[0][4]=playerSymbol;
                break;
            case 4:
                board[2][0]=playerSymbol;
                break;
            case 5:
                board[2][2]=playerSymbol;
                break;
            case 6:
                board[2][4]=playerSymbol;
                break;
            case 7:
                board[4][0]=playerSymbol;
                break;
            case 8:
                board[4][2]=playerSymbol;
                break;
            case 9:
                board[4][4]=playerSymbol;
                break;
            default:
                break;
        }
        return board;
    }
    
    /**
     * This method allows the Computer to play
     * @return 
     */
    public int computerPlayer()
    {
        Random ram=new Random();
        int comp=ram.nextInt(9) + 1;
        return comp;
    }
    
    public String checkWinner()
    {
        
        return "";
    }
    
}
