package TicTacToe.Exceptions;

public class InvalidBotCOuntException extends Exception{
    public InvalidBotCOuntException() {
    }

    public InvalidBotCOuntException(String message) {
        super(message);
    }

    public InvalidBotCOuntException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBotCOuntException(Throwable cause) {
        super(cause);
    }

    public InvalidBotCOuntException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
