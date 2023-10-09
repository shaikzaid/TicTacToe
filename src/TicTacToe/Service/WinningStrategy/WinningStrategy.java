package TicTacToe.Service.WinningStrategy;

import TicTacToe.Board;
import TicTacToe.Move;
import TicTacToe.Player;

public interface WinningStrategy {
    Player checkWinner(Board board, Move lastMove);
}
