package pe.edu.upc.NigthWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NigthWave.entities.Recompensas;
import java.util.List;

@Repository
public interface IRecompensasRepository extends JpaRepository<Recompensas, Integer> {
    List<Recompensas> findByTipoRecompensa(String tipoRecompensa);
}

