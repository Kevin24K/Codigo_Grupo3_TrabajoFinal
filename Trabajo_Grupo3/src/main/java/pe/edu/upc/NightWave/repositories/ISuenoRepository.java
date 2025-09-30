package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.Sueno;

import java.util.List;

@Repository
public interface ISuenoRepository extends JpaRepository<Sueno, Integer> {


}
