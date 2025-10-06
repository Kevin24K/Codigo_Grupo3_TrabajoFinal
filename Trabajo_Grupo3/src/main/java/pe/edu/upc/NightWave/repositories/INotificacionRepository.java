package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.Notificacion;

import java.util.List;

@Repository
public interface INotificacionRepository extends JpaRepository<Notificacion, Integer>
{
    // Spring Data entiende que debe buscar por idUsuario.id
    List<Notificacion> findByIdUsuarioId(Long idUsuario);

    List<Notificacion> findByIdUsuarioIdAndLeidaFalse(Long idUsuario);
}

