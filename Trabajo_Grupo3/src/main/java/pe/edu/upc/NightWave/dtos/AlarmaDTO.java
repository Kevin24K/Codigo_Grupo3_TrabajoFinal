package pe.edu.upc.NightWave.dtos;

import jakarta.persistence.*;
import pe.edu.upc.NightWave.entities.MusicaMultimedia;
import pe.edu.upc.NightWave.entities.Usuario;

import java.time.LocalTime;

public class AlarmaDTO
{
    private int id;
    private String nombreAlarma;
    private LocalTime horaAlarma;
    private String diasSemana;
    private double volumen;
    private boolean activa;
    private Usuario usuario;
    private MusicaMultimedia contenido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MusicaMultimedia getContenido() {
        return contenido;
    }

    public void setContenido(MusicaMultimedia contenido) {
        this.contenido = contenido;
    }
}
