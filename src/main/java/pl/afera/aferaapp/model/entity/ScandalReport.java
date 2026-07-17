package pl.afera.aferaapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "scandal_reports")
@Entity
public class ScandalReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, message = "Minimum 5 znaków")
    private String scandalName;
    @Size(min = 5, message = "Minimum 5 znaków")
    private String scandalDescription;
    @Column(columnDefinition = "TEXT")
    private String sources;
    private String additionalComments;
}
