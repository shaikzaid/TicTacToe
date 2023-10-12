package TicTacToe.Service.BotPlayingStrategy;

import TicTacToe.BotplayingStrategy;

public class BotPlayingStrategyFractory {
    public static BotplayingStrategy getBotPalyingStrategy(){
        return new RandomBotPlayingStrategy();
    }
}
