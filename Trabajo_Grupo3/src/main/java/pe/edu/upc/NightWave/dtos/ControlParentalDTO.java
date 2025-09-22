package pe.edu.upc.NightWave.dtos;

import java.time.LocalDateTime;

public class ControlParentalDTO {
    private int idControl;
    private int idPadre;
    private int idHijo;
    private String restricciones;
    private LocalDateTime fechaAsignacion;

    public int getIdControl() {
        return idControl;
    }

    public void setIdControl(int idControl) {
        this.idControl = idControl;
    }

    public int getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(int idPadre) {
        this.idPadre = idPadre;
    }

    public int getIdHijo() {
        return idHijo;
    }

    public void setIdHijo(int idHijo) {
        this.idHijo = idHijo;
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
