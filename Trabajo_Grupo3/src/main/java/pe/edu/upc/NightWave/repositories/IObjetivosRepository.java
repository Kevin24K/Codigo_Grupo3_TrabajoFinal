package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.Objetivos;

import java.util.List;

@Repository
public interface IObjetivosRepository extends JpaRepository<Objetivos,Integer> {

    // Query para obtener promedio de progreso por usuario
    @Query(value = """
        SELECT u.username,
               ROUND(CAST(AVG((o.valor_actual / o.valor_objetivo) * 100) AS numeric), 2) AS promedioProgreso
        FROM Objetivo o
        JOIN Users u ON o.id_usuario = u.id
        WHERE o.valor_objetivo > 0
        GROUP BY u.username
        ORDER BY promedioProgreso DESC
        """, nativeQuery = true)
    public List<String[]> promedioProgresoPorUsuario();

    // Query para visualizar cuántos objetivos han sido alcanzados o no por cada usuario
    @Query(value = """
            SELECT 
                u.username AS nombreUsuario,
                SUM(CASE WHEN o.alcanzado = TRUE THEN 1 ELSE 0 END) AS objetivosAlcanzados,
                SUM(CASE WHEN o.alcanzado = FALSE THEN 1 ELSE 0 END) AS objetivosNoAlcanzados
            FROM 
                Objetivo o
            JOIN 
                Users u ON o.id_usuario = u.id
            GROUP BY 
                u.username
            ORDER BY 
                objetivosAlcanzados DESC
            """, nativeQuery = true)
    public List<String[]> objetivosAlcanzadosPorUsuario();





}
