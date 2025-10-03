package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Objetivos_Recompensas;

import java.util.List;

public interface IObjetivosRecompensasService {
    void insert(Objetivos_Recompensas objetivosRecompensas);
    List<Objetivos_Recompensas> list();
    void delete(int id);
    Objetivos_Recompensas listId(int id);
    void update(Objetivos_Recompensas objetivosRecompensas);

    List<Objetivos_Recompensas> findByObjetivoId(int objetivoId);
    Long countByRecompensaId(int recompensaId);
}
