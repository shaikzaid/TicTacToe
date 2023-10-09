package TicTacToe.Service.BotPlayingStrategy;

import TicTacToe.BotplayingStrategy;

public class BotPlayingStrategyFractory {
    public BotplayingStrategy getBotPalyingStrategy(){
        return new RandomBotPlayingStrategy();
    }
}
