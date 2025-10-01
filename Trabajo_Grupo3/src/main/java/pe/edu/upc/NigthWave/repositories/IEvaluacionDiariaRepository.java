package pe.edu.upc.NigthWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NigthWave.entities.EvaluacionDiaria;

@Repository
public interface IEvaluacionDiariaRepository extends JpaRepository<EvaluacionDiaria, Integer> {
}
