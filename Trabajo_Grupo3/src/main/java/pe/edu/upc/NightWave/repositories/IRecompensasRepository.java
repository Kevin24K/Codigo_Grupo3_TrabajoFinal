package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.Recompensas;
import java.util.List;

@Repository
public interface IRecompensasRepository extends JpaRepository<Recompensas, Integer> {
}

