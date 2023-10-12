package TicTacToe;

import TicTacToe.Exceptions.GameOverException;

import java.util.Scanner;

public class Player {
    private String name;
    private int id;
    private char symbol;
    private PlayerType playerType;

  //  public CellState cellState;


    public Player(String name, int id, char symbol,PlayerType playerType) {
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board) throws GameOverException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the row for your move");
        int row=scn.nextInt();
        System.out.println("Enter the col for your Move");
        int col= scn.nextInt();
//        if(row > board.getSize()-1 && cellState.equals(CellState.FILLED)){
//            System.out.println("Please enter at valid cell ");
//            makeMove(Board board);
//        }
        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(this);
        return new Move(row,col,this);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
