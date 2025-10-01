package pe.edu.upc.NigthWave.servicesinterfaces;

import pe.edu.upc.NigthWave.entities.EvaluacionDiaria;

import java.util.List;

public interface IEvaluacionDiariaService
{
    public void insert(EvaluacionDiaria evaluacionDiaria);
    public List<EvaluacionDiaria> list();
    public void delete(int id);
    public EvaluacionDiaria listId(int id);
    public void update(EvaluacionDiaria evaluacionDiaria);
}
