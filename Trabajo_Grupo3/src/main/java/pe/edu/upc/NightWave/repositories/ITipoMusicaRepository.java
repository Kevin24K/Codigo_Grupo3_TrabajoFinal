package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.TipoMusica;

@Repository
public interface ITipoMusicaRepository extends JpaRepository<TipoMusica,Integer> 
{
    @Query(value = "SELECT t.nombre_tipo, \n" +
            "COUNT(m.id) AS total_musica FROM Musica_Multimedia m \n" +
            "JOIN Tipo_Musica t ON m.tipo_musica_id = t.id \n" +
            "GROUP BY t.nombre_tipo;", nativeQuery = true)
    public List<String[]> NroDeMusicaXTipo();
}
