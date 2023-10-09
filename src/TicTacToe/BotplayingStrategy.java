package TicTacToe;

import TicTacToe.Exceptions.GameOverException;

public interface BotplayingStrategy {

    Move makeMove(Board board) throws GameOverException;
}
