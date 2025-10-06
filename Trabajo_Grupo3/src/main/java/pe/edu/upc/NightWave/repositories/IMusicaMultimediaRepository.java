package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.MusicaMultimedia;

@Repository
public interface IMusicaMultimediaRepository extends JpaRepository<MusicaMultimedia, Integer> {
    @Query(value = "SELECT \n" +
            "    m.id AS musica_id,\n" +
            "    m.nombre AS nombre_musica,\n" +
            "    COUNT(a.id) AS veces_usada,\n" +
            "    ROUND( (COUNT(a.id) * 100.0 / SUM(COUNT(a.id)) OVER()), 2 ) AS porcentaje_uso\n" +
            "FROM \n" +
            "    Musica_Multimedia m\n" +
            "JOIN \n" +
            "    Alarma a ON a.contenido_id = m.id\n" +
            "GROUP BY \n" +
            "    m.id, m.nombre\n" +
            "ORDER BY \n" +
            "    veces_usada DESC;", nativeQuery = true)
    public List<String[]> BuscarMusicasMasUsadasEnAlarmas();
}