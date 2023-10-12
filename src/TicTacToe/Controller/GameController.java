package TicTacToe.Controller;

import TicTacToe.*;
import TicTacToe.Service.WinningStrategy.OrderOneWinningStrategy;
import TicTacToe.Service.WinningStrategy.WinningStrategies;
import TicTacToe.Service.WinningStrategy.WinningStrategyFactory;

import java.util.List;
import java.util.Map;

public class GameController {
    public Game createGame(int dimensions, List<Player> players, WinningStrategies winningStrategies){
        try {
            return Game.builder().dimension(dimensions).
                    setPlayer(players).
                    setWinningStrategy(WinningStrategyFactory.getWinningStrategy(winningStrategies, dimensions)).build();
        }
        catch (Exception e){
            System.out.println("ERROR"+e.getMessage());
            System.out.println("Could not start the game , something went wrong");
        }
        return null;
    }
    public void displayBoard(Game game){
        game.getCurrentBoard().printBoard();
    }
    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }
    public Player getGameWinner(Game game){
        return game.getWinner();
    }
    public Move executeMove(Game game,Player player) throws Exception{
        Move move=player.makeMove(game.getCurrentBoard());
        game.setNoOfSymbol(game.getNoOfSymbol()+1);
        updateGameMoves(game,move);
        updateBoardStates(game);
        return move;
    }
    public Player checkWinner(Game game,Move lastPlayedMove){
        Player player=game.getWinningStrategy().checkWinner(game.getCurrentBoard(),lastPlayedMove);
        if(player!= null){
            game.setWinner(player);
            game.setGameStatus(GameStatus.CIMPLETED);
            return player;
        }
        return null;
    }
    public Board undoMove(Game game,Move lastMove){
        return null;
    }
    public void replayGame(Game game){
        // logic write
    }
    public void updateGameMoves(Game game,Move move){
        game.getMoves().add(move);
    }
    public void updateBoardStates(Game game){
        game.getBoardStates().add(new Board(game.getCurrentBoard()));
    }
    public void updateGameStatus(Game game){
       int numofSymbol=game.getNoOfSymbol();
       int dimension=game.getCurrentBoard().getSize();
       if(numofSymbol == (dimension*dimension)){
           game.setGameStatus(GameStatus.DRAW);
       }
    }

}
