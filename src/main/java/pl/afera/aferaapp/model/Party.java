package pl.afera.aferaapp.model;

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
@Table(name = "parties")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=5, message="The name must contain at least five characters.")
    private String name;
    @ManyToMany(targetEntity = Politician.class)
    @JoinTable(
            name = "party_politicians",
            joinColumns = @JoinColumn(name = "party_id"),
            inverseJoinColumns = @JoinColumn(name = "politician_id")
    )
    @Size(min = 1, message="Partia musi mieć przynajmniej jednego członka")
    private List<Politician> members = new ArrayList<>();
}
