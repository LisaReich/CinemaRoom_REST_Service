package cinema;

public class CinemaService {
    Cinema cinema = new Cinema(9, 9);
    Statistics statistics = new Statistics(0, 81, 0);

    public Cinema getSeatsView() {
        return cinema;
    }

    public Ticket buyTicket(Seat reqSeat) {

        if (reqSeat.getRow() > cinema.getTotal_rows() ||
                reqSeat.getColumn() > cinema.getTotal_columns() ||
                reqSeat.getRow() <= 0 ||
                reqSeat.getColumn() <= 0) {
            throw new SeatBoundsException();

        } else {
            for (Seat seat : cinema.available_seats) {

                if (seat.getColumn() == reqSeat.getColumn() &&
                        seat.getRow() == reqSeat.getRow() && !seat.isAvailable()) {
                    throw new TicketPurchaseException();

                } else if (seat.getColumn() == reqSeat.getColumn() &&
                        seat.getRow() == reqSeat.getRow() && seat.isAvailable()) {

                    seat.setAvailable(false);
                    Ticket ticket = new Ticket(seat);
                    cinema.tickets.put(ticket.getToken(), ticket);
                    updateStatistics(seat, true);

                    return ticket;
                }
            }
        }

        throw new RuntimeException();
    }

    public ReturnedTicket returnTicket(Token token) {
        if (cinema.tickets.containsKey(token.getToken())) {

            Ticket ticket = cinema.tickets.get(token.getToken());
            updateStatistics(cinema.tickets.get(token.getToken()).getSeat(), false);
            cinema.tickets.remove(token.getToken());

            return new ReturnedTicket(ticket.getSeat());

        } else {
            throw new TokenIsIncorrectException();
        }
    }

    public Statistics getStatistics(String password) {
        if (password != null) {
            if (password.equals("super_secret")) {
                return statistics;
            }
        }

        throw new PasswordIsIncorrectException();
    }

    public void updateStatistics(Seat seat, boolean income) {
        if (income) {
            statistics.setCurrentIncome(statistics.currentIncome + seat.getPrice());
            statistics.setAvailSeatsNumber(statistics.availSeatsNumber - 1);
            statistics.setPurchasedTicketNumber(statistics.getPurchasedTicketNumber() + 1);
        } else {
            statistics.setCurrentIncome(statistics.currentIncome - seat.getPrice());
            statistics.setAvailSeatsNumber(statistics.availSeatsNumber + 1);
            statistics.setPurchasedTicketNumber(statistics.getPurchasedTicketNumber() - 1);
        }
    }
}
