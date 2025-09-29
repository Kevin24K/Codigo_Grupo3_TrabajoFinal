package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.ObjetivosRecompensas;

import java.util.List;

@Repository
public interface IObjetivosRecompensasRepository extends JpaRepository<ObjetivosRecompensas,Integer> {
    // Query para listar todas las recompensas obtenidas por un objetivo específico
    @Query("SELECT or FROM ObjetivosRecompensas or WHERE or.objetivo.id = :objetivoId")
    List<ObjetivosRecompensas> findByObjetivoId(@Param("objetivoId") int objetivoId);

    // Query para contar el número de veces que se ha obtenido una recompensa
    @Query("SELECT COUNT(or) FROM ObjetivosRecompensas or WHERE or.recompensa.idRecompensa = :recompensaId")
    Long countByRecompensaId(@Param("recompensaId") int recompensaId);

}
