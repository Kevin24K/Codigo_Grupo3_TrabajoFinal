package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.Roles;

import java.util.List;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Long> {
    // Query para encontrar roles por el ID de usuario
    @Query("SELECT r FROM Roles r WHERE r.usuario.id = :usuarioId")
    List<Roles> findByUserId(@Param("usuarioId") Long usuarioId);
}
