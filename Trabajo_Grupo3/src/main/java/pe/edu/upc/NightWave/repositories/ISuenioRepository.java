package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.NightWave.entities.Suenio;

public interface ISuenioRepository extends JpaRepository<Suenio, Integer> {
}
