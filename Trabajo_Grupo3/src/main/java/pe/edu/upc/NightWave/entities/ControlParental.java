package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "control_parental")
public class ControlParental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idControl;

    @ManyToOne
    @JoinColumn(name = "id_padre", nullable = false)
    private Usuario padre;

    @ManyToOne
    @JoinColumn(name = "id_hijo", nullable = false)
    private Usuario hijo;

    @Column(name = "restricciones", columnDefinition = "TEXT")
    private String restricciones;

    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDateTime fechaAsignacion = LocalDateTime.now();

    public ControlParental(int idControl, Usuario padre, Usuario hijo, String restricciones, LocalDateTime fechaAsignacion) {
        this.idControl = idControl;
        this.padre = padre;
        this.hijo = hijo;
        this.restricciones = restricciones;
        this.fechaAsignacion = fechaAsignacion;
    }

    public ControlParental() {}

    public int getIdControl() {
        return idControl;
    }

    public void setIdControl(int idControl) {
        this.idControl = idControl;
    }

    public Usuario getPadre() {
        return padre;
    }

    public void setPadre(Usuario padre) {
        this.padre = padre;
    }

    public Usuario getHijo() {
        return hijo;
    }

    public void setHijo(Usuario hijo) {
        this.hijo = hijo;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
}
