package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.NightWave.entities.Notificacion;

public interface INotificacionRepository extends JpaRepository<Notificacion, Integer> {
}
