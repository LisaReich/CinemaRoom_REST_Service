package cinema;

public class PasswordIsIncorrectException extends RuntimeException{
    public PasswordIsIncorrectException() {
        super("The password is wrong!");
    }
}
