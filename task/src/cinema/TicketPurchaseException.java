package cinema;

public class TicketPurchaseException extends RuntimeException {
    public TicketPurchaseException() {
        super("The ticket has been already purchased!");
    }
}
