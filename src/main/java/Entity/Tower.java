package Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tower")
public class Tower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 5, max = 100)
    private String name;

    @NotBlank
    @Size(min = 5)
    private String location;

    @NotNull
    @DecimalMin(value = "10.00")
    @DecimalMax(value = "300.00")
    private BigDecimal height;

    @NotNull
    @PastOrPresent(message = "La fecha debe ser actual o pasada")
    @Column(name = "installation_date")
    private LocalDate installationDate;

    @ManyToOne
    @JoinColumn(name = "state_id")
    @NotNull(message = "Debe seleccionar un estado")
    private TowerState state;
}
