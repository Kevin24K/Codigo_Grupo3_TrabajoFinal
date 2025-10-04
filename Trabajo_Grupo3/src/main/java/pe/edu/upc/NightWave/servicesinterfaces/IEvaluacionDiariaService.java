package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.EvaluacionDiaria;

import java.time.LocalDate;
import java.util.List;

public interface IEvaluacionDiariaService
{
    public void insert(EvaluacionDiaria evaluacionDiaria);
    public List<EvaluacionDiaria> list();
    public void delete(int id);
    public EvaluacionDiaria listId(int id);
    public void update(EvaluacionDiaria evaluacionDiaria);

    //Busqueda
    public List<EvaluacionDiaria> buscarEvaluacion(LocalDate fechaInicio, LocalDate fechaFin);

}
