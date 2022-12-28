package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Ticket {
    @JsonProperty("ticket")
    private Seat seat;
    private UUID token;

    public Ticket(Seat seat) {
        this.seat = seat;
        this.token = UUID.randomUUID();
    }

    public Seat getSeat() {
        return seat;
    }

    public UUID getToken() {
        return token;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
