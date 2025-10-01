package pe.edu.upc.NigthWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NigthWave.entities.Notificacion;

import java.util.List;

@Repository
public interface INotificacionRepository extends JpaRepository<Notificacion, Integer>
{
    @Query("SELECT n FROM Notificacion n WHERE n.usuario.id = :usuarioId")
    List<Notificacion> findByUsuarioId(@Param("usuarioId") int usuarioId);

    // Query para listar notificaciones no leídas de un usuario
    @Query("SELECT n FROM Notificacion n WHERE n.usuario.id = :usuarioId AND n.leida = false")
    List<Notificacion> findByUsuarioIdAndLeidaFalse(@Param("usuarioId") int usuarioId);
}
