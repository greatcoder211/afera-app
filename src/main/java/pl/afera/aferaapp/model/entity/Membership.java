package pl.afera.aferaapp.model.entity;

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
    @ManyToOne
    @JoinColumn(name = "party_id")
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
