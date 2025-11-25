package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.Habitos;

import java.util.List;

@Repository
public interface IHabitosRepository extends JpaRepository<Habitos, Integer> {

    @Query(value = "SELECT h.nombre_habito as Habito, u.username as Usuario " +
            "FROM habito h " +
            "INNER JOIN users u ON h.id_usuario = u.id " +
            "WHERE u.id = :user_id AND h.activo = true " +
            "GROUP BY h.nombre_habito, u.username",
            nativeQuery = true)
    List<String[]> HabitosActivosParaUnUsuario(@Param("user_id") Long user_id);
}
