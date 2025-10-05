package pe.edu.upc.NightWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NightWave.entities.EvaluacionDiaria;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IEvaluacionDiariaRepository extends JpaRepository<EvaluacionDiaria, Integer> {

    //Busqueda
    @Query("SELECT idEvaluacionDiaria, estadoAnimo, nivelEnergia, recomendaciones, fechaEvaluacion, idUsuario\n" +
            " FROM EvaluacionDiaria\n" +
            " WHERE fechaEvaluacion BETWEEN :fechaInicio AND :fechaFin")
    public List<EvaluacionDiaria> buscarPorFecha(@Param("fechaInicio") LocalDate fechaInicio
                                                , @Param("fechaFin") LocalDate fechaFin);

    //Query
    @Query(value = "SELECT u.username, COUNT(e.id_evaluacion_diaria) " +
            " FROM evaluacion_diaria e " +
            " JOIN users u ON e.id_usuario = u.id " +
            " GROUP BY u.username", nativeQuery = true)
    List<String[]> cantidadEvaluacionesPorUsuario();








}
