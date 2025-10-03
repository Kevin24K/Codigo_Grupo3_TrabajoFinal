package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.Notificaciones;

import java.util.List;

@Repository
public interface INotificacionesRepository extends JpaRepository<Notificaciones, Integer> {
    // Query para listar notificaciones por usuario
    @Query("SELECT n FROM Notificaciones n WHERE n.usuario.id = :usuarioId")
    List<Notificaciones> findByUsuarioId(@Param("usuarioId") int usuarioId);

    // Query para listar notificaciones no leídas de un usuario
    @Query("SELECT n FROM Notificaciones n WHERE n.usuario.id = :usuarioId AND n.leida = false")
    List<Notificaciones> findByUsuarioIdAndLeidaFalse(@Param("usuarioId") int usuarioId);
}
