package pe.edu.upc.NightWave.dtos;

import pe.edu.upc.NightWave.entities.MusicaMultimedia;
import pe.edu.upc.NightWave.entities.Usuario;

import java.time.LocalDateTime;

public class ActividadDTO
{
    private int id;
    private String tipoActividad;
    private String nombre;
    private String descripcion;
    private int duracionMinutos;
    private String intensidad;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private boolean completada;
    private int nivelEstresAntes;
    private int nivelEstresDespues;
    private int puntuacionSatisfaccion;
    private int IdUsuario;
    private int IdMusica;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
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

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public int getIdMusica() {
        return IdMusica;
    }

    public void setIdMusica(int idMusica) {
        IdMusica = idMusica;
    }
}
