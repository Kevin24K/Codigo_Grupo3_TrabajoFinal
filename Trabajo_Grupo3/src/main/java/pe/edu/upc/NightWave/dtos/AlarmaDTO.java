package pe.edu.upc.NightWave.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.NightWave.entities.MusicaMultimedia;
import pe.edu.upc.NightWave.entities.Users;

import java.time.LocalTime;

public class AlarmaDTO
{
    private int idAlarma;
    private String nombreAlarma;
    private LocalTime horaAlarma;
    private String diasSemana;
    private boolean activa;
    private Users idUsuario;
    private MusicaMultimedia idMusicaMultimedia;

    public int getIdAlarma() {
        return idAlarma;
    }

    public void setIdAlarma(int idAlarma) {
        this.idAlarma = idAlarma;
    }

    public String getNombreAlarma() {
        return nombreAlarma;
    }

    public void setNombreAlarma(String nombreAlarma) {
        this.nombreAlarma = nombreAlarma;
    }

    public LocalTime getHoraAlarma() {
        return horaAlarma;
    }

    public void setHoraAlarma(LocalTime horaAlarma) {
        this.horaAlarma = horaAlarma;
    }

    public String getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(String diasSemana) {
        this.diasSemana = diasSemana;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Users getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Users idUsuario) {
        this.idUsuario = idUsuario;
    }

    public MusicaMultimedia getIdMusicaMultimedia() {
        return idMusicaMultimedia;
    }

    public void setIdMusicaMultimedia(MusicaMultimedia idMusicaMultimedia) {
        this.idMusicaMultimedia = idMusicaMultimedia;
    }
}
