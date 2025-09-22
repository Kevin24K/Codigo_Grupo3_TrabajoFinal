package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Actividad")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_actividad", length = 50, nullable = false)
    private String tipoActividad;

    @Column(name = "nombre", length = 150, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 300, nullable = false)
    private String descripcion;

    @Column(name = "duracion_minutos", nullable = false)
    private int duracionMinutos;

    @Column(name = "intensidad", length = 20, nullable = false)
    private String intensidad;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fechaFin;

    @Column(name = "completada", nullable = false)
    private boolean completada;

    @Column(name = "nivel_estres_antes", nullable = false)
    private int nivelEstresAntes;

    @Column(name = "nivel_estres_despues", nullable = false)
    private int nivelEstresDespues;

    @Column(name = "puntuacion_satisfaccion", nullable = false)
    private int puntuacionSatisfaccion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "musica_id", nullable = false)
    private MusicaMultimedia musica;

    // Constructor vacío
    public Actividad() {}

    // Constructor completo
    public Actividad(int id, String tipoActividad, String nombre, String descripcion, int duracionMinutos,
                     String intensidad, LocalDateTime fechaInicio, LocalDateTime fechaFin, boolean completada,
                     int nivelEstresAntes, int nivelEstresDespues, int puntuacionSatisfaccion,
                     Usuario usuario, MusicaMultimedia musica) {
        this.id = id;
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
        this.usuario = usuario;
        this.musica = musica;
    }

    // Getters y Setters
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MusicaMultimedia getMusica() {
        return musica;
    }

    public void setMusica(MusicaMultimedia musica) {
        this.musica = musica;
    }
}
