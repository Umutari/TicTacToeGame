/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.controller;
import java.util.Random;
import tictactoegame.view.Gameboard;
import tictactoegame.model.TicTacToeModel;
/**
 *
 * @author Yvette
 */
public class TicTacToeController {
    TicTacToeModel model;
    Gameboard view;
    private int player=1;
    Random ram;
    
    /**
     * This is a constructor
     * @param board
     */
    public TicTacToeController(Gameboard board)
    {
        model=new TicTacToeModel();
        view=board;
        board.onBoardReady(model.getBoard());
        ram=new Random();
    }
    
    public interface InnerTicTacController
    {
        /**
         * called when the board is ready to play
         * @param board
         */
        void onBoardReady(String[][] board);
        
        /**
         * called if a player result is a winner
         * @param player won on the game
         */
        void onWinnerEmerged(int player);
        
        /**
         * called a selected position already has a value
         * The player who just attempted to play needs to play a different spot
         * @param player 
         */
        void onSpaceTaken(int player);
        
        /**
         * called when the next player is about to play
         * @param nextPlayer 
         * @param board 
         */
        void onNextPlayer(int nextPlayer, String[][] board);
        
        /**
         * calls when there is bad input
         * @param player 
         */
        void onBadInput(int player);
        
        /**
         * called when all possible spots are filled
         * There is no winner
         */
        void onTie();
        
    }
    
    /**
     * This method validates user input
     * @param input
     * @param board 
     */
    public void validate(int input, Gameboard board)
    {
        if(input<=0 || input>9)
            {
                board.onBadInput(0);
            }
        else
        {
            isSpotAvailable(input);
        }
    }
    
    /**
     * This method checks if there is available spot to play in
     * @param position
     * @return 
     */
    public boolean isSpotAvailable(int position)
    {
        int x=position/3;
        int y=position%3;
        if(model.getBoard()[x][y].trim().equals(""))
        {
            play(x,y);
            return true; 
        }
        else
        {
            view.onSpaceTaken(player);
            return false;
        }
    }
    
    /**
     * This method allows the play to play
     * @param x
     * @param y 
     */
    public void play(int x, int y)
    {
        String value=player==1?"X":"O";
        model.setBoard(x, y, value);
        player=player==1?2:1;
        view.onNextPlayer(player, model.getBoard());
    }
    
    /**
     * This method allows the Computer to play
     */
    public void computerPlayer()
    {
        int comp=ram.nextInt(9)+1;
        isSpotAvailable(comp);
        
        
    }
}
