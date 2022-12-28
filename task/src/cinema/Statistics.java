package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statistics {
    @JsonProperty(value = "current_income")
    int currentIncome;
    @JsonProperty(value = "number_of_available_seats")
    int availSeatsNumber;
    @JsonProperty(value = "number_of_purchased_tickets")
    int purchasedTicketNumber;

    public Statistics(int currentIncome, int availSeatsNumber, int purchasedTicketNumber) {
        this.currentIncome = currentIncome;
        this.availSeatsNumber = availSeatsNumber;
        this.purchasedTicketNumber = purchasedTicketNumber;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public int getAvailSeatsNumber() {
        return availSeatsNumber;
    }

    public void setAvailSeatsNumber(int availSeatsNumber) {
        this.availSeatsNumber = availSeatsNumber;
    }

    public int getPurchasedTicketNumber() {
        return purchasedTicketNumber;
    }

    public void setPurchasedTicketNumber(int purchasedTicketNumber) {
        this.purchasedTicketNumber = purchasedTicketNumber;
    }
}
