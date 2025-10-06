package pe.edu.upc.NightWave.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.NightWave.entities.Habitos;

import java.util.List;

public interface IHabitosService
{
    public void insert(Habitos habitos);
    public List<Habitos> list();
    public void delete(int id);
    public Habitos listId(int id);
    public void update(Habitos habitos);
    public List<String[]> HabitosActivosParaUnUsuario(@Param("user_id") Long user_id);
}
