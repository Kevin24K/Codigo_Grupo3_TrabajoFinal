package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.NightWave.entities.Sueno;

public interface ISuenoRepository extends JpaRepository<Sueno,Integer> {
}
