/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.controller;
import java.util.Scanner;
import tictactoegame.view.Gameboard;
import tictactoegame.model.TicTacToeModel;
/**
 *
 * @author Yvette
 */
public class TicTacToeController {
    TicTacToeModel boardchar;
    Gameboard board;
    
    /**
     * This is a constructor
     * @param board
     * @param boardchar 
     */
    public TicTacToeController(Gameboard board,TicTacToeModel boardchar)
    {
        this.board=board;
        this.boardchar=boardchar;
    }
    
    /**
     * This methods prints the board
     */
    public void printBoard()
    {
        board.Board(boardchar.drawBoard());
        
    }
    
    /**
     * This method places the character into the position the player has played
     * 
    */
    public void position()
    {
        while(true)
        {
            
            System.out.println("****YOUR TURN****");
            
            String player="player";
            board.Board(boardchar.initBoard(boardchar.drawBoard(),boardchar.humanPlayer(),player));
            System.out.println("****COMPUTER'S TURN****");
            board.Board(boardchar.initBoard(boardchar.drawBoard(),boardchar.computerPlayer(),"computer"));
            
        }
    }
}
