package pl.afera.aferaapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Entity
public class Politician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private List<Membership> memberships = new ArrayList<>();
    //ile ukradł
    private BigDecimal confirmedEmbezzledAmountOfMoney;
    //ile możliwie ukradł
    private BigDecimal unconfirmedEmbezzledAmountOfMoney;
}
