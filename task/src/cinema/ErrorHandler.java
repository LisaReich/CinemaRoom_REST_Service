package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(PasswordIsIncorrectException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorMessage handleException(PasswordIsIncorrectException e) {
        return new ErrorMessage(e.getMessage());
    }

    @ExceptionHandler(SeatBoundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleException(SeatBoundsException e) {
        return new ErrorMessage(e.getMessage());
    }

    @ExceptionHandler(TicketPurchaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleException(TicketPurchaseException e) {
        return new ErrorMessage(e.getMessage());
    }

    @ExceptionHandler(TokenIsIncorrectException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleException(TokenIsIncorrectException e) {
        return new ErrorMessage(e.getMessage());
    }
}
