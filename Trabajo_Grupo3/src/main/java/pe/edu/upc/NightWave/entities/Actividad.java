package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Actividad")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActividad;

    @Column(name = "tipoActividad", length = 50, nullable = false)
    private String tipoActividad;

    @Column(name = "nombre", length = 150, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 300, nullable = false)
    private String descripcion;

    @Column(name = "duracionMinutos", nullable = false)
    private int duracionMinutos;

    @Column(name = "intensidad", length = 20, nullable = false)
    private String intensidad;

    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fechaFin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "completada", nullable = false)
    private boolean completada;

    @Column(name = "nivelEstresAntes", nullable = false)
    private int nivelEstresAntes;

    @Column(name = "nivelEstresDespues", nullable = false)
    private int nivelEstresDespues;

    @Column(name = "puntuacionSatisfaccion", nullable = false)
    private int puntuacionSatisfaccion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Users idUsuario;

    @ManyToOne
    @JoinColumn(name = "idMusica", nullable = false)
    private MusicaMultimedia idMusica;

    // Constructor vacío
    public Actividad() {}

    // Constructor completo


    public Actividad(int idActividad, String tipoActividad, String nombre, String descripcion, int duracionMinutos, String intensidad, LocalDate fechaInicio, LocalDate fechaFin, boolean completada, int nivelEstresAntes, int nivelEstresDespues, int puntuacionSatisfaccion, Users idUsuario, MusicaMultimedia idMusica) {
        this.idActividad = idActividad;
        this.tipoActividad = tipoActividad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMinutos = duracionMinutos;
        this.intensidad = intensidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.completada = completada;
        this.nivelEstresAntes = nivelEstresAntes;
        this.nivelEstresDespues = nivelEstresDespues;
        this.puntuacionSatisfaccion = puntuacionSatisfaccion;
        this.idUsuario = idUsuario;
        this.idMusica = idMusica;
    }

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
