package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.ControlParental;
import java.util.List;

public interface IControlParentalService {
    void insert(ControlParental controlParental);
    List<ControlParental> list();
    void delete(int id);
    ControlParental listId(int id);
    void update(ControlParental controlParental);
}
