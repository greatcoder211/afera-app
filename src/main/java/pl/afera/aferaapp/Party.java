package pl.afera.aferaapp;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=5, message="The name must contain at least five characters.")
    private String name;
    @ManyToMany(targetEntity = Politician.class)
    @JoinTable(
            name = "Party_Politicians",
            joinColumns = @JoinColumn(name = "party"),
            inverseJoinColumns = @JoinColumn(name = "politician")
    )
    @Size(min = 1, message="Partia musi mieć przynajmniej jednego członka")
    private List<Politician> members = new ArrayList<>();
    private BigDecimal confirmedEmbezzledAmountOfMoney;
    private BigDecimal unconfirmedEmbezzledAmountOfMoney;
}
