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
        board.Board(boardchar.playBoard());
        
    }
    
    /**
     * This method places the character into the position the player has played
     * 
    */
    public void position()
    {
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter your position from 1 - 9");
        int placement=scan.nextInt();
        String player="player";
        System.out.print(boardchar.initBoard(placement,player));
        board.Board(boardchar.playBoard());
    }
}
