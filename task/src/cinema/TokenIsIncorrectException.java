package cinema;

public class TokenIsIncorrectException extends RuntimeException {
    public TokenIsIncorrectException() {
        super("Wrong token!");
    }
}
