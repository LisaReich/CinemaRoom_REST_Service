package cinema;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaController {

    CinemaService cinemaService = new CinemaService();

    @GetMapping("/seats")
    public Cinema getCinemaInfo() {
        return cinemaService.getSeatsView();
    }

    @PostMapping("/purchase")
    public ResponseEntity<Ticket> purchaseSeat(@RequestBody Seat reqSeat) {
        return ResponseEntity.ok(cinemaService.buyTicket(reqSeat));
    }

    @PostMapping("/return")
    public ResponseEntity<ReturnedTicket> returnSeat(@RequestBody Token token) {
        return ResponseEntity.ok(cinemaService.returnTicket(token));
    }

    @PostMapping("/stats")
    public ResponseEntity<Statistics> showStats(@RequestParam(required = false) String password) {
        return ResponseEntity.ok(cinemaService.getStatistics(password));
    }
}
