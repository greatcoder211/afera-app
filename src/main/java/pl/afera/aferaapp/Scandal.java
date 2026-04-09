package pl.afera.aferaapp;

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
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Scandal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @NotNull
    private int startYear;
    private int endYear;
//TODO: zmien nazwe tabel laczonych- patrz punkt XXIII
    @ManyToMany
    @JoinTable(
            name = "Scandal_Parties",
            joinColumns = @JoinColumn(name = "scandal"),
            inverseJoinColumns = @JoinColumn(name = "party")
    )
    private List<Party> associatedPoliticalParties = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "Scandal_Politicians",
            joinColumns = @JoinColumn(name = "scandal"),
            inverseJoinColumns = @JoinColumn(name = "politician")
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
