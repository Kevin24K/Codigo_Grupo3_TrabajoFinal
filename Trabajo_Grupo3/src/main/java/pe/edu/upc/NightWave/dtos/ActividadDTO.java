package pe.edu.upc.NightWave.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.NightWave.entities.MusicaMultimedia;
import pe.edu.upc.NightWave.entities.Users;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ActividadDTO
{
    private int idActividad;
    private String tipoActividad;
    private String nombre;
    private String descripcion;
    private int duracionMinutos;
    private String intensidad;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean completada;
    private int nivelEstresAntes;
    private int nivelEstresDespues;
    private int puntuacionSatisfaccion;
    private Users idUsuario;
    private MusicaMultimedia idMusica;

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public int getNivelEstresAntes() {
        return nivelEstresAntes;
    }

    public void setNivelEstresAntes(int nivelEstresAntes) {
        this.nivelEstresAntes = nivelEstresAntes;
    }

    public int getNivelEstresDespues() {
        return nivelEstresDespues;
    }

    public void setNivelEstresDespues(int nivelEstresDespues) {
        this.nivelEstresDespues = nivelEstresDespues;
    }

    public int getPuntuacionSatisfaccion() {
        return puntuacionSatisfaccion;
    }

    public void setPuntuacionSatisfaccion(int puntuacionSatisfaccion) {
        this.puntuacionSatisfaccion = puntuacionSatisfaccion;
    }

    public Users getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Users idUsuario) {
        this.idUsuario = idUsuario;
    }

    public MusicaMultimedia getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(MusicaMultimedia idMusica) {
        this.idMusica = idMusica;
    }
}
