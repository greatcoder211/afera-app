package pl.afera.aferaapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Entity
public class Politician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal confirmedEmbezzledAmountOfMoney;
    private BigDecimal unconfirmedEmbezzledAmountOfMoney;
}
