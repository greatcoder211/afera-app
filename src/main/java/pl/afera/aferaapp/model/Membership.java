package pl.afera.aferaapp.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Year;
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "memberships")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partyName;
    private LocalDate entryDate;
    private LocalDate departureDate;
    public Membership(String partyName, LocalDate entryDate, LocalDate departureDate) {
        this.partyName = partyName;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
    }
    public Membership(String partyName, LocalDate entryDate) {
        this.partyName = partyName;
        this.entryDate = entryDate;
        departureDate = LocalDate.of(Year.now().getValue(), -1, -1);
    }
}
