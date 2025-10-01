package pe.edu.upc.NigthWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NigthWave.entities.SeguimientoHabitos;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISeguimientoHabitosRepository extends JpaRepository<SeguimientoHabitos,Integer>
{
    // Query para encontrar el seguimiento de un hábito por usuario
    @Query("SELECT sh FROM SeguimientoHabitos sh WHERE sh.usuario.id = :usuarioId")
    List<SeguimientoHabitos> findByUsuarioId(@Param("usuarioId") int usuarioId);

    // Query para encontrar los hábitos completados por usuario
    @Query("SELECT sh FROM SeguimientoHabitos sh WHERE sh.usuario.id = :usuarioId AND sh.completado = true")
    List<SeguimientoHabitos> findByUsuarioIdAndEstadoCumplimientoTrue(@Param("usuarioId") int usuarioId);

    // Query para encontrar los hábitos no completados por usuario
    @Query("SELECT sh FROM SeguimientoHabitos sh WHERE sh.usuario.id = :usuarioId AND sh.completado = false")
    List<SeguimientoHabitos> findByUsuarioIdAndEstadoCumplimientoFalse(@Param("usuarioId") int usuarioId);

    // Query para encontrar los hábitos de un usuario en una fecha específica
    @Query("SELECT sh FROM SeguimientoHabitos sh WHERE sh.usuario.id = :usuarioId AND sh.fechaSeguimiento = :fecha")
    List<SeguimientoHabitos> findByUsuarioIdAndFechaRegistro(@Param("usuarioId") int usuarioId, @Param("fecha") LocalDate fecha);
}
