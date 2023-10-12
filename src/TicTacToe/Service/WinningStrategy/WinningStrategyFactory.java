package TicTacToe.Service.WinningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(WinningStrategies winningStrategy,int dimensions){
        return new OrderOneWinningStrategy(dimensions);
    }
}
