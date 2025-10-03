package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.SeguimientoHabitos;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISeguimientoHabitosRepository extends JpaRepository<SeguimientoHabitos, Integer> {
    // Query para encontrar el seguimiento de un hábito por usuario
    @Query("SELECT sh FROM SeguimientoHabitos sh WHERE sh.usuario.id = :usuarioId")
    List<SeguimientoHabitos> findByUsuarioId(@Param("usuarioId") int usuarioId);

    // Query para encontrar los hábitos completados por usuario
    @Query("SELECT sh FROM SeguimientoHabitos sh WHERE sh.usuario.id = :usuarioId AND sh.estadoCumplimiento = true")
    List<SeguimientoHabitos> findByUsuarioIdAndEstadoCumplimientoTrue(@Param("usuarioId") int usuarioId);

    // Query para encontrar los hábitos no completados por usuario
    @Query("SELECT sh FROM SeguimientoHabitos sh WHERE sh.usuario.id = :usuarioId AND sh.estadoCumplimiento = false")
    List<SeguimientoHabitos> findByUsuarioIdAndEstadoCumplimientoFalse(@Param("usuarioId") int usuarioId);

    // Query para encontrar los hábitos de un usuario en una fecha específica
    @Query("SELECT sh FROM SeguimientoHabitos sh WHERE sh.usuario.id = :usuarioId AND sh.fechaRegistro = :fecha")
    List<SeguimientoHabitos> findByUsuarioIdAndFechaRegistro(@Param("usuarioId") int usuarioId, @Param("fecha") LocalDate fecha);
}
