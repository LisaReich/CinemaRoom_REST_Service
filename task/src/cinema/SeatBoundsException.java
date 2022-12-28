package cinema;

public class SeatBoundsException extends RuntimeException {
    public SeatBoundsException() {
        super("The number of a row or a column is out of bounds!");
    }
}
