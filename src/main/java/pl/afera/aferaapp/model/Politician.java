package pl.afera.aferaapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Entity
@Table(name = "politicians")
public class Politician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany(targetEntity = Membership.class)
    @JoinTable(
            name = "politician_memberships",
            joinColumns = @JoinColumn(name = "politicianId"),
            inverseJoinColumns = @JoinColumn(name = "membershipId")
    )
    private List<Membership> memberships = new ArrayList<>();
    //ile ukradł
    private BigDecimal confirmedEmbezzledAmountOfMoney;
    //ile możliwie ukradł
    private BigDecimal unconfirmedEmbezzledAmountOfMoney;
}
