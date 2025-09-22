package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.Estres;

@Repository
public interface IEstresRepository extends JpaRepository<Estres, Integer> {
}
