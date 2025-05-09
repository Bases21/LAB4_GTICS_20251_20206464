package Repository;
import Entity.Tower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TowerRepository extends JpaRepository<Tower, Integer> {
}