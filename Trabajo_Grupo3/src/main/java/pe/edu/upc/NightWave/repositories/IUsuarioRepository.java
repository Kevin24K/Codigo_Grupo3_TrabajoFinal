package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>
{
    @Query("SELECT u FROM Usuario u WHERE u.rol.idRol = :rolId")
    List<Usuario> listarUsuariosPorRol(@Param("rolId") int rolId);

}
