package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.Sueno;

import java.util.List;

@Repository
public interface ISuenoRepository extends JpaRepository<Sueno, Integer> {

    List<Sueno> findByCalidadSuenoLessThanEqualOrderByFechaRegistroDesc(int umbralCalidad);

    @Query(value = "SELECT id_usuario, " +
            " AVG(EXTRACT(EPOCH FROM (hora_despertar - hora_Acostarse))/3600) AS promedioHorasDormidas, " +
            " AVG(interrupciones) AS promedioInterrupciones, " +
            " AVG(calidad_Sueno) AS promedioCalidadSueno " +
            " FROM sueno " +
            " GROUP BY id_usuario",
            nativeQuery = true
    )
    List<Object[]> promedioSuenoTodosUsuarios();

    @Query(value = "SELECT id_usuario, " +
            " fecha_Registro::date AS fecha_registro, " +
            " EXTRACT(EPOCH FROM (hora_Despertar - hora_Acostarse))/3600 AS horas_dormidas " +
            " FROM sueno " +
            " WHERE hora_Acostarse IS NOT NULL AND hora_Despertar IS NOT NULL " +
            " ORDER BY id_usuario, fecha_Registro",
            nativeQuery = true)
    List<Object[]> horasDormidasPorUsuarioPorRegistro();
}


