package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.MusicaMultimedia;

@Repository
public interface IMusicaMultimediaRepository extends JpaRepository<MusicaMultimedia, Integer> {
}
