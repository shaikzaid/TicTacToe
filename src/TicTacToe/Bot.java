package TicTacToe;

import TicTacToe.Exceptions.GameOverException;
import TicTacToe.Service.BotPlayingStrategy.BotPlayingStrategyFractory;

import java.security.PrivateKey;

public class Bot extends Player{
    private BotDufficultyLevel botDufficultyLevel;

    public Bot(String name, int id, char symbol, PlayerType playerType,BotDufficultyLevel botDufficultyLevel) {
        super(name, id, symbol, playerType);
        this.botDufficultyLevel=botDufficultyLevel;
    }

    @Override
    public Move makeMove(Board board) throws GameOverException {
        BotplayingStrategy botplayingStrategy= BotPlayingStrategyFractory.getBotPalyingStrategy();
        return botplayingStrategy.makeMove(board,this);
    }
}
