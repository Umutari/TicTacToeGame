/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.view;
import java.util.Scanner;
import tictactoegame.controller.TicTacToeController;
import tictactoegame.controller.TicTacToeController.InnerTicTacController;


/**
 *
 * @author Yvette
 */
public class Gameboard implements InnerTicTacController{
    
    TicTacToeController controller;
    Scanner scan =new Scanner(System.in);
    /**
     * Constructor
     */
    public Gameboard()
    {
        controller=new TicTacToeController(this);
        requestInput();
        
    }
    
    /**
     * This method prints the board
     * @param board 
     */
    public void printBoard(String[][] board)
    {
        System.out.println("----+---+----");
        for(int i=0; i<3; i++)
        {
            System.out.print("| ");
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n----+---+----");
        }
    }
    
    /**
     * This method requests input from the Human player
     */
    public void requestInput()
    {
        System.out.println("Enter your position from 1 - 9");
            int placement=scan.nextInt();    
            controller.validate(placement, this);
    }
    
    @Override
    public void onBoardReady(String[][]  board) {
        printBoard(board);
    }

    
    @Override
    public void onBadInput(int player) {
        System.out.println("The input was incorrect!!!Choose (1 - 9)");
        requestInput();
            
    }
    
    @Override
    public void onWinnerEmerged(int player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onSpaceTaken(int player) {
    
        System.out.println("This spot is taken!! Try a different spot");
        if(player==1)
        {
            requestInput();
        }
        else
        {
            controller.computerPlayer();
        }
    }

    @Override
    public void onNextPlayer(int nextPlayer, String[][] board) {
    
        printBoard(board);
        if(nextPlayer==1)
        {
            System.out.println("****YOUR TURN****");
            requestInput();
        }
        else
        {
            System.out.println("****COMPUTER'S TURN****");
            controller.computerPlayer();
        }
    }

    @Override
    public void onTie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
