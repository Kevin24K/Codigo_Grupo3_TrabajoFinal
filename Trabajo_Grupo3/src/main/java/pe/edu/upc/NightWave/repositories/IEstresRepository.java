package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.Estres;

import java.util.List;

@Repository
public interface IEstresRepository extends JpaRepository<Estres, Integer> {

    @Query(value = """
            SELECT 
                u.username AS nombreUsuario,
                ROUND(AVG(e.nivel_estres)::numeric, 2) AS promedioEstres,
                ROUND(AVG(e.nivel_ansiedad)::numeric, 2) AS promedioAnsiedad
            FROM 
                Estres e
            JOIN 
                Users u ON e.id_usuario= u.id
            GROUP BY 
                u.username
            ORDER BY 
                promedioEstres DESC
            """, nativeQuery = true)
    List<String[]> promedioEstresYAnsiedadPorUsuario();

    @Query(value = """
            SELECT 
                TO_CHAR(e.fecha_registro, 'YYYY-MM') AS mes,
                COUNT(*) AS cantidadRegistros
            FROM 
                Estres e
            GROUP BY 
                TO_CHAR(e.fecha_registro, 'YYYY-MM')
            ORDER BY 
                mes ASC
            """, nativeQuery = true)
    List<String[]> conteoEstresPorMes();
}
