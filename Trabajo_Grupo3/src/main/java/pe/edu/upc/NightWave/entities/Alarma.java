package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "Alarma")
public class Alarma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_alarma", length = 100, nullable = false)
    private String nombreAlarma;

    @Column(name = "hora_alarma", nullable = false)
    private LocalTime horaAlarma;

    @Column(name = "dias_semana", length = 50, nullable = false)
    private String diasSemana;

    @Column(name = "volumen", nullable = false)
    private double volumen;

    @Column(name = "activa", nullable = false)
    private boolean activa;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "contenido_id", nullable = false)
    private MusicaMultimedia contenido;

    // Constructor vacío
    public Alarma() {}

    // Constructor completo
    public Alarma(int id, String nombreAlarma, LocalTime horaAlarma, String diasSemana, double volumen, boolean activa, Usuario usuario, MusicaMultimedia contenido) {
        this.id = id;
        this.nombreAlarma = nombreAlarma;
        this.horaAlarma = horaAlarma;
        this.diasSemana = diasSemana;
        this.volumen = volumen;
        this.activa = activa;
        this.usuario = usuario;
        this.contenido = contenido;
    }

    // Getters y Setters
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
