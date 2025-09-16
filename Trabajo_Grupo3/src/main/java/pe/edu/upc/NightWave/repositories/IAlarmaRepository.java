package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.NightWave.entities.Alarma;

public interface IAlarmaRepository extends JpaRepository<Alarma, Integer> {
}
