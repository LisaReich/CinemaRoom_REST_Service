package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Cinema {
    int total_rows;
    int total_columns;
    ArrayList<Seat> available_seats = new ArrayList<>();
    @JsonIgnore
    Map<UUID, Ticket> tickets = new ConcurrentHashMap<>();

    public Cinema(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;

        for (int i = 0; i < total_rows; i++) {
            for (int j = 0; j < total_columns; j++) {
                available_seats.add(new Seat(i + 1, j + 1));
            }
        }
    }

    public void setAvailable_seats(ArrayList<Seat> available_seats) {
        this.available_seats = available_seats;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public ArrayList<Seat> getAvailable_seats() {
        return available_seats;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }
}