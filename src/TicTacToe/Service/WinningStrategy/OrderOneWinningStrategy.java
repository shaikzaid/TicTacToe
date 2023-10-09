package TicTacToe.Service.WinningStrategy;

import TicTacToe.Board;
import TicTacToe.Move;
import TicTacToe.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy{
    private int dimensions;
    private List<HashMap<Character,Integer>> rowHashMap;
    private List<HashMap<Character,Integer>> colHashMap;
    private HashMap<Character,Integer> topLeftHashMap;
    private HashMap<Character,Integer> topRightHashMap;
    private HashMap<Character,Integer> cornerHashMap;

    public OrderOneWinningStrategy(int dimensions) {
        this.dimensions = dimensions;
        rowHashMap=new ArrayList<>();
        colHashMap=new ArrayList<>();
        topLeftHashMap=new HashMap<>();
        topRightHashMap= new HashMap<>();
        cornerHashMap=new HashMap<>();
        for(int i=0;i<dimensions;i++){
            rowHashMap.add(new HashMap<>());
            colHashMap.add(new HashMap<>());
        }
    }
   public boolean isTopLeftDiagobanCell(int row,int col){
        return row == col;
   }
   public boolean isTopRightDioganalCell(int row, int col)
   {
       return (row-col)==dimensions-1;
   }
   public boolean isCornerCell(int row , int col){
        // what are the corners [0,0] [0, dimension-1] [dimension-1,0] [dimension-1,dimension-1]
       if(row == 0 || row == dimensions-1)
           return col ==0 || col ==dimensions-1;
       return false;
   }
    @Override
    public Player checkWinner(Board board, Move lastMove) {
        Player player= lastMove.getPlayer();
        char symbol= player.getSymbol();
        int row=lastMove.getCell().getRow();
        int col=lastMove.getCell().getCol();
       if(checkRowWin(row,symbol))
           return player;
       else if (checkColumnWin(col,symbol))
           return player;
       else if (isTopLeftDiagobanCell(row,col) && checkTopLeftDiagonalWin(symbol))
           return player;
       else if(isTopRightDioganalCell(row , col) && checkTopRightDiagonalWin(symbol))
           return player;
       else if(isCornerCell(row,col)&& checkCornerWin(row,col,symbol))
           return player;

       return null;
    }
    public boolean checkRowWin(int row, char symbol){
   // if(!rowHashMap.get(row).containsKey(symbol)){
        rowHashMap.get(row).putIfAbsent(symbol,0);  // this technique putIfAbsent is used instead of if conditions
       // rowHashMap.get(row).put(symbol,0);
   // }
    rowHashMap.get(row).put(symbol,rowHashMap.get(row).get(symbol)+1);
//    if(rowHashMap.get(row).get(symbol)==dimensions)
//        return true;
//    return false;
        // above is conventional if conditons
      return rowHashMap.get(row).get(symbol)== dimensions;

    }
    public boolean checkColumnWin(int col, char symbol){
// if(!rowHashMap.get(row).containsKey(symbol)){
        colHashMap.get(col).putIfAbsent(symbol,0);  // this technique putIfAbsent is used instead of if conditions
        // rowHashMap.get(row).put(symbol,0);
        // }
        colHashMap.get(col).put(symbol,colHashMap.get(col).get(symbol)+1);
//    if(rowHashMap.get(row).get(symbol)==dimensions)
//        return true;
//    return false;
        // above is conventional if conditons
        return colHashMap.get(col).get(symbol)== dimensions;

    }
    public boolean checkTopRightDiagonalWin(char symbol){
// if(!rowHashMap.containsKey(symbol)){
        topRightHashMap.putIfAbsent(symbol,0);  // this technique putIfAbsent is used instead of if conditions
        // rowHashMap.put(symbol,0);
        // }
        topRightHashMap.put(symbol,topRightHashMap.get(symbol)+1);
//    if(rowHashMap.get(symbol)==dimensions)
//        return true;
//    return false;
        // above is conventional if conditons
        return topRightHashMap.get(symbol)== dimensions;

    }
    public boolean checkTopLeftDiagonalWin( char symbol){
        //       if(!rowHashMap.containsKey(symbol)){
            topLeftHashMap.putIfAbsent(symbol,0);  // this technique putIfAbsent is used instead of if conditions
            // rowHashMap.put(symbol,0);
            // }
        topLeftHashMap.put(symbol,topLeftHashMap.get(symbol)+1);
//    if(rowHashMap.get(symbol)==dimensions)
//        return true;
//    return false;
            // above is conventional if conditons
            return topLeftHashMap.get(symbol)== dimensions;

    }
    public boolean checkCornerWin(int row, int col, char symbol){
        //       if(!rowHashMap.containsKey(symbol)){
        cornerHashMap.putIfAbsent(symbol,0);  // this technique putIfAbsent is used instead of if conditions
        // rowHashMap.put(symbol,0);
        // }
        cornerHashMap.put(symbol,cornerHashMap.get(symbol)+1);
//    if(rowHashMap.get(symbol)==dimensions)
//        return true;
//    return false;
        // above is conventional if conditons
        return cornerHashMap.get(symbol)== 4;

    }
}
