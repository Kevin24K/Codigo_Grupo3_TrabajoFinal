package pe.edu.upc.NigthWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NigthWave.entities.Sueno;

import java.util.List;

@Repository
public interface ISuenoRepository extends JpaRepository<Sueno, Integer> {
    List<Sueno> findByCalidadSueno(int calidadSueno);

    @Query(value = "SELECT AVG(EXTRACT(EPOCH FROM (hora_despertar - hora_acostarse))/3600) " +
            "FROM sueno WHERE usuario_id = :usuarioId", nativeQuery = true)
    Double promedioHorasDormidasPorUsuario(@Param("usuarioId") int usuarioId);

    @Query(value = "SELECT usuario_id, AVG(EXTRACT(EPOCH FROM (hora_despertar - hora_acostarse))/3600) " +
            "FROM sueno GROUP BY usuario_id", nativeQuery = true)
    List<Object[]> promedioHorasDormidasTodosUsuarios();

    @Query(value = "SELECT usuario_id, " +
            "AVG(nivel_estres_dia) AS promedio_estres, " +
            "AVG(calidad_sueno) AS promedio_calidad_sueno, " +
            "CORR(nivel_estres_dia, calidad_sueno) AS correlacion_estres_calidad " +
            "FROM sueno " +
            "WHERE usuario_id = :usuarioId " +
            "GROUP BY usuario_id", nativeQuery = true)
    Object[] relacionEstresCalidadPorUsuario(@Param("usuarioId") int usuarioId);

}
