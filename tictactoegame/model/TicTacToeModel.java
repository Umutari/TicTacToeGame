/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.model;

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
}
