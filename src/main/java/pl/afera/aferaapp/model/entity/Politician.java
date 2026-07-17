package pl.afera.aferaapp.model.entity;

import jakarta.persistence.*;
import lombok.*;

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
            joinColumns = @JoinColumn(name = "politician_id"),
            inverseJoinColumns = @JoinColumn(name = "membership_id")
    )
    private List<Membership> memberships = new ArrayList<>();
}
