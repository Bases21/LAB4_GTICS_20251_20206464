package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tower_state")
public class TowerState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;


}
