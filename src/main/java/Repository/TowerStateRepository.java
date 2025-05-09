package Repository;

import Entity.TowerState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TowerStateRepository extends JpaRepository<TowerState, Integer> {
}