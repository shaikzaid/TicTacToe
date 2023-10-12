package TicTacToe;

import TicTacToe.Exceptions.DuplicateSymbolException;
import TicTacToe.Exceptions.InvalidBoardSizeException;
import TicTacToe.Exceptions.InvalidBotCOuntException;
import TicTacToe.Exceptions.InvalidNumberOfPlayersException;
import TicTacToe.Service.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board currentBoard;
 private List<Player> players;
 private  Player currentplayer;
 private GameStatus gameStatus;
 private Player winner;

 private  List<Move> moves;
 private List<Board> boardStates;
 private WinningStrategy winningStrategy;
 private int noOfSymbol;

 private Game(Board currentBoard, List<Player> players, WinningStrategy winningStrategy) {
  this.currentBoard = currentBoard;
  this.players = players;
  this.gameStatus = GameStatus.IN_PROGRESS;
  this.moves = new ArrayList<Move>();
  this.boardStates = new ArrayList<Board>();
  this.winningStrategy = winningStrategy;
  this.noOfSymbol=0;
 }

 public int getNoOfSymbol() {
  return noOfSymbol;
 }

 public void setNoOfSymbol(int noOfSymbol) {
  this.noOfSymbol = noOfSymbol;
 }

 public Board getCurrentBoard() {
  return currentBoard;
 }

 public void setCurrentBoard(Board currentBoard) {
  this.currentBoard = currentBoard;
 }

 public List<Player> getPlayers() {
  return players;
 }

 public void setPlayers(List<Player> players) {
  this.players = players;
 }

 public Player getCurrentplayer() {
  return currentplayer;
 }

 public void setCurrentplayer(Player currentplayer) {
  this.currentplayer = currentplayer;
 }

 public GameStatus getGameStatus() {
  return gameStatus;
 }

 public void setGameStatus(GameStatus gameStatus) {
  this.gameStatus = gameStatus;
 }

 public Player getWinner() {
  return winner;
 }

 public void setWinner(Player winner) {
  this.winner = winner;
 }

 public List<Move> getMoves() {
  return moves;
 }

 public void setMoves(List<Move> moves) {
  this.moves = moves;
 }

 public List<Board> getBoardStates() {
  return boardStates;
 }

 public void setBoardStates(List<Board> boardStates) {
  this.boardStates = boardStates;
 }

 public WinningStrategy getWinningStrategy() {
  return winningStrategy;
 }

 public void setWinningStrategy(WinningStrategy winningStrategy) {
  this.winningStrategy = winningStrategy;
 }


 public static Builder builder(){    ///builder method  this is BUilder Module
  return new Builder();
}
 public static class Builder{     // Builder class
 private WinningStrategy winningStrategy;
  private List<Player> player;
  private int dimensions;

  public Builder setWinningStrategy(WinningStrategy winningStrategy) {
   this.winningStrategy = winningStrategy;
   return this;
  }

  public Builder setPlayer(List<Player> player) {
   this.player = player;
   return this;
  }

  public Builder dimension (int dimensions) {
   this.dimensions = dimensions;
   return this;
  }
  public void validateBotCount() throws InvalidBotCOuntException {
   int botCount=0;
     for(Player player1: player){
      if(player1.getPlayerType().equals(PlayerType.BOT)){
       botCount++;
      }
     }
     if(botCount>1){
        throw new InvalidBotCOuntException("Bot count more than one currently it is  = "+botCount);
     }
  }
  public void validateBoardSize() throws Exception{
   if(dimensions < 3 || dimensions > 10 ){
    throw new InvalidBoardSizeException( " boars size is either less than 3 or gerater than 10");
   }
  }
  public void ValidatePlayerNumber() throws Exception{
   if(player.size() != (dimensions-1)){
    throw new InvalidNumberOfPlayersException("Number of player is invalis current count is"+ player.size());
   }
  }
  public void validateDuplicateSymbol() throws Exception{
   HashSet<Character> symbol= new HashSet<>();
   for(Player player1: player){
    symbol.add(player1.getSymbol());
   }
   if(symbol.size() != player.size()){
    throw new DuplicateSymbolException("Player Symbol are not unique");
   }
  }
  public void validate() throws Exception {
   validateBoardSize();
   validateBotCount();
   validateDuplicateSymbol();
   ValidatePlayerNumber();
  }
  public Game build() throws Exception{
   validate();
   return new Game(new Board(dimensions),player,winningStrategy);
 }

}

}
