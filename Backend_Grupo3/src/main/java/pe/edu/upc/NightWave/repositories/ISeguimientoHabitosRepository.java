package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.SeguimientoHabitos;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISeguimientoHabitosRepository extends JpaRepository<SeguimientoHabitos,Integer>
{
    @Query(value = "SELECT h.nombre_habito AS habito, u.username AS usuario " +
            "FROM seguimiento_habito sh " +
            "INNER JOIN habito h ON h.id_habitos = sh.id_seguimiento_habitos " +
            "INNER JOIN users u ON u.id = sh.id_usuario " +
            "WHERE sh.completado = true " +
            "GROUP BY h.nombre_habito, u.username",
            nativeQuery = true)
    List<String[]> HabitosCompletadosPorUsuario();

    @Query(value = "SELECT h.nombre_habito AS habito, u.username AS usuario " +
            "FROM seguimiento_habito sh " +
            "INNER JOIN habito h ON h.id_habitos = sh.id_seguimiento_habitos " +
            "INNER JOIN users u ON u.id = sh.id_usuario " +
            "WHERE sh.completado = false " +
            "GROUP BY h.nombre_habito, u.username",
            nativeQuery = true)
    List<String[]> HabitosNoCompletadosPorUsuario();
}
