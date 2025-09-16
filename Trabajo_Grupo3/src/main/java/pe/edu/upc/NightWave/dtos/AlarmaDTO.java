package pe.edu.upc.NightWave.dtos;

import java.time.LocalTime;

public class AlarmaDTO {
    private int idAlarma;
    private int idUsuario;
    private int idSonido;
    private LocalTime horaAlarma;
    private String diasActivos;
    private boolean activa;

    // Getters y Setters
    public int getIdAlarma() {
        return idAlarma;
    }

    public void setIdAlarma(int idAlarma) {
        this.idAlarma = idAlarma;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSonido() {
        return idSonido;
    }

    public void setIdSonido(int idSonido) {
        this.idSonido = idSonido;
    }

    public LocalTime getHoraAlarma() {
        return horaAlarma;
    }

    public void setHoraAlarma(LocalTime horaAlarma) {
        this.horaAlarma = horaAlarma;
    }

    public String getDiasActivos() {
        return diasActivos;
    }

    public void setDiasActivos(String diasActivos) {
        this.diasActivos = diasActivos;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
