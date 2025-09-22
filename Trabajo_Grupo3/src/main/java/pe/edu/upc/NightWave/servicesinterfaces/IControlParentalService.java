package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.ControlParental;
import java.util.List;

public interface IControlParentalService {
    public void insert(ControlParental controlParental);
    public List<ControlParental> list();
    public void delete(int id);
    public ControlParental listId(int id);
    public void update(ControlParental controlParental);
}
