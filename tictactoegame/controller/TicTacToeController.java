/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.controller;
import tictactoegame.view.Gameboard;
import tictactoegame.model.TicTacToeModel;
/**
 *
 * @author Yvette
 */
public class TicTacToeController {
    TicTacToeModel boardchar;
    Gameboard playboard;
    
    /**
     * This is a constructor
     * @param playboard
     * @param boardchar 
     */
    public TicTacToeController(Gameboard playboard,TicTacToeModel boardchar)
    {
        this.playboard=playboard;
        this.boardchar=boardchar;
    }
    
    /**
     * This methods prints the board
     */
    public void printBoard()
    {
        playboard.Board(boardchar.playBoard());
        
    }
}
