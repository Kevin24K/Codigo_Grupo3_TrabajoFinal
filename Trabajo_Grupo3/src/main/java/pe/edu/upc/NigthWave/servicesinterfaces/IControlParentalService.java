package pe.edu.upc.NigthWave.servicesinterfaces;

import pe.edu.upc.NigthWave.entities.ControlParental;
import java.util.List;

public interface IControlParentalService {
    public void insert(ControlParental controlParental);
    public List<ControlParental> list();
    public void delete(int id);
    public ControlParental listId(int id);
    public void update(ControlParental controlParental);
}
