package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import pe.edu.upc.NightWave.entities.Recompensas;

public interface IRecompensasRepository extends JpaRepository<Recompensas, Integer> { }
=======
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.Recompensas;
import java.util.List;

@Repository
public interface IRecompensasRepository extends JpaRepository<Recompensas, Integer> {
}
>>>>>>> origin/Gabriel

