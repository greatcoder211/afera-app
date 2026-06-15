package pl.afera.aferaapp;

import java.time.LocalDate;
import java.time.Year;

public class Membership {
    private Politician politician;
    private Party party;
    private LocalDate entryDate;
    private LocalDate departureDate;
    public Membership(Party party, LocalDate entryDate, LocalDate departureDate) {
        this.party = party;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
    }
    public Membership(Party party, LocalDate entryDate) {
        this.party = party;
        this.entryDate = entryDate;
        departureDate = LocalDate.of(Year.now().getValue(), -1, -1);
    }
}
