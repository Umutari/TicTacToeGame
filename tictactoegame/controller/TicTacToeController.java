/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    
    ArrayList<Integer>playerPositions = new ArrayList<>();
    ArrayList<Integer>cpuPositions = new ArrayList<>();
    
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
         * called when there is a bad input
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
        int y=(position%3)-1;
        
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
     * This method allows the player to play
     * @param x
     * @param y 
     */
    public void play(int x, int y)
    {
        if(model.getBoard().length!=9)
        {
            String value=player==1?"X":"O";
            model.setBoard(x, y, value);
            player=player==1?2:1;
            view.onNextPlayer(player, model.getBoard());
        }
        else
        {
            view.onWinnerEmerged(player);
            view.onTie();
        }
    }
    
    /**
     * This method allows the Computer to play
     */
    public void computerPlayer()
    {
        int comp=ram.nextInt(9)+1;
        isSpotAvailable(comp);
    }
    
    /**
     * This method checks for the winner
     * @return 
     */
    public String checkWinner()
    {
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List diag1 = Arrays.asList(1,5,9);
        List diag2 = Arrays.asList(3,5,7);
        
        List<List>winner = new ArrayList<>();
        winner.add(topRow);
        winner.add(midRow);
        winner.add(botRow);
        winner.add(leftCol);
        winner.add(midCol);
        winner.add(rightCol);
        winner.add(diag1);
        winner.add(diag2);
        
        for(List l: winner)
        {
            if(playerPositions.containsAll(l))
            {
                return "COngratulations you won!!";
            }
            else if(cpuPositions.containsAll(l))
            {
                return "Sorry!!, Computer Won";
            }
        }
        
        return "";
    }
    
    /**
     * This method is called once the board is full and there is no winner
     * @return 
     */
    public String checkForTie()
    {
        if(playerPositions.size()+cpuPositions.size()==9)
        {
            return "It is a tie";
        }
        return "";
    }
}
