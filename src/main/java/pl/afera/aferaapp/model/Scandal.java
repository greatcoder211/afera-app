package pl.afera.aferaapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "scandals")
public class Scandal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @NotNull
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToMany
    @JoinTable(
            name = "scandal_parties",
            joinColumns = @JoinColumn(name = "scandal_id"),
            inverseJoinColumns = @JoinColumn(name = "party_id")
    )
    private Set<Party> associatedPoliticalParties = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "scandal_politicians",
            joinColumns = @JoinColumn(name = "scandal_id"),
            inverseJoinColumns = @JoinColumn(name = "politician_id")
    )
    private Set<Politician> associatedPoliticians = new HashSet<>();
    private BigDecimal confirmedEmbezzledAmountOfMoney;
    private BigDecimal unconfirmedEmbezzledAmountOfMoney;
    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = updatedAt = now;
    }
    @PreUpdate
    public void preUpdate(){
        updatedAt = LocalDateTime.now();
    }
}
