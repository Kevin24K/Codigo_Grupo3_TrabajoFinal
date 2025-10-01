package pe.edu.upc.NigthWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NigthWave.entities.EvaluacionDiaria;
import pe.edu.upc.NigthWave.repositories.IEvaluacionDiariaRepository;
import pe.edu.upc.NigthWave.servicesinterfaces.IEvaluacionDiariaService;

import java.util.List;

@Service
public class EvaluacionDiariaServiceImplement implements IEvaluacionDiariaService
{
    @Autowired
    private IEvaluacionDiariaRepository edR;

    @Override
    public void insert(EvaluacionDiaria evaluacionDiaria) {
        edR.save(evaluacionDiaria);
    }

    @Override
    public List<EvaluacionDiaria> list() {
        return edR.findAll();
    }

    @Override
    public void delete(int id) {
        edR.deleteById(id);
    }

    @Override
    public EvaluacionDiaria listId(int id) {
        return edR.findById(id).orElse(null);
    }

    @Override
    public void update(EvaluacionDiaria evaluacionDiaria) {
        edR.save(evaluacionDiaria);
    }
}
