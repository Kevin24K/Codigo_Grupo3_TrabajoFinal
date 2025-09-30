package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.SeguimientoHabitos;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISeguimientoHabitosRepository extends JpaRepository<SeguimientoHabitos,Integer>
{


}
