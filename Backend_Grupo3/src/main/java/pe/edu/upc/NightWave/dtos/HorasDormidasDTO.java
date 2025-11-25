package pe.edu.upc.NightWave.dtos;

import java.time.LocalDate;

public class HorasDormidasDTO {

    private int idUsuario;
    private LocalDate fechaRegistro;
    private double horasDormidas;

    public HorasDormidasDTO() {
    }

    public HorasDormidasDTO(int idUsuario, LocalDate fechaRegistro, double horasDormidas) {
        this.idUsuario = idUsuario;
        this.fechaRegistro = fechaRegistro;
        this.horasDormidas = horasDormidas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public double getHorasDormidas() {
        return horasDormidas;
    }

    public void setHorasDormidas(double horasDormidas) {
        this.horasDormidas = horasDormidas;
    }
}
