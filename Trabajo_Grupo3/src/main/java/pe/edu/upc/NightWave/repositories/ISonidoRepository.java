package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.Sonido;

@Repository
public interface ISonidoRepository extends JpaRepository<Sonido, Integer> {
}