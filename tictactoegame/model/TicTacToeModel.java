/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.model;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Yvette
 */
public class TicTacToeModel {
    
    String[][] board={{" "," ", " "},
            {" "," ", " "},
            {" "," ", " "}};
    
    /**
     * This method returns the character of the board (How it looks like)
     * @return 
     */
    public String[][] drawBoard()
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
    public String[][] initBoard(String[][]board,int pos, String user)
    {
        String playerSymbol= "";
        switch (user) {
            case "player":
                playerSymbol="X";
                break;
            case "computer":
                playerSymbol="O";
                break; 
        }
        board=this.board;
        
        int x=pos/3;
        int y=(pos%3)-1;

        if(!board[x][y].equals("X") && !board[x][y].equals("O") )
        {
            board[x][y]=playerSymbol;
        }
        else
        {
            System.out.println("Position Taken");
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
        int comp=ram.nextInt(9);
        return comp;
    }
    
    public int humanPlayer()
    {
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter your position from 1 - 9");
            int placement=scan.nextInt();
            if(placement>8)
            {
                System.out.println("Out of bounds!!!Choose (1 - 9)");
                placement=scan.nextInt();
            }
            return placement;
    }
    
    public String checkWinner()
    {
        
        return "";
    }
    
}
