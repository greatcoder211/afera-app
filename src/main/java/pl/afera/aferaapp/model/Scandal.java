package pl.afera.aferaapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private int startYear;
    private int endYear;
//TODO: zmien nazwe tabel laczonych- patrz punkt XXIII
    @ManyToMany
    @JoinTable(
            name = "scandal_parties",
            joinColumns = @JoinColumn(name = "scandalId"),
            inverseJoinColumns = @JoinColumn(name = "partieId")
    )
    private List<Party> associatedPoliticalParties = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "scandal_politicians",
            joinColumns = @JoinColumn(name = "scandalId"),
            inverseJoinColumns = @JoinColumn(name = "politicianId")
    )
    private List<Politician> associatedPoliticians = new ArrayList<>();
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
