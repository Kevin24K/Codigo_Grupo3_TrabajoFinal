package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Objetivo")
public class Objetivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idObjetivos;

    @Column(name = "nombreObjetivo", length = 200, nullable = false)
    private String nombreObjetivo;

    @Column(name = "tipoObjetivo", length = 50, nullable = false)
    private String tipoObjetivo;

    @Column(name = "descripcion", length = 300, nullable = false)
    private String descripcion;

    @Column(name = "valorObjetivo", nullable = false)
    private double valorObjetivo;

    @Column(name = "valorActual", nullable = false)
    private double valorActual;

    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fechaFin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "alcanzado", nullable = false)
    private boolean alcanzado;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Users idUsuario;

    // Constructor vacío
    public Objetivos() {}

    // Constructor completo

    public Objetivos(int idObjetivos, String nombreObjetivo, String tipoObjetivo, String descripcion, double valorObjetivo, double valorActual, LocalDate fechaInicio, LocalDate fechaFin, boolean alcanzado, Users idUsuario) {
        this.idObjetivos = idObjetivos;
        this.nombreObjetivo = nombreObjetivo;
        this.tipoObjetivo = tipoObjetivo;
        this.descripcion = descripcion;
        this.valorObjetivo = valorObjetivo;
        this.valorActual = valorActual;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.alcanzado = alcanzado;
        this.idUsuario = idUsuario;
    }

    public int getIdObjetivos() {
        return idObjetivos;
    }

    public void setIdObjetivos(int idObjetivos) {
        this.idObjetivos = idObjetivos;
    }

    public String getNombreObjetivo() {
        return nombreObjetivo;
    }

    public void setNombreObjetivo(String nombreObjetivo) {
        this.nombreObjetivo = nombreObjetivo;
    }

    public String getTipoObjetivo() {
        return tipoObjetivo;
    }

    public void setTipoObjetivo(String tipoObjetivo) {
        this.tipoObjetivo = tipoObjetivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValorObjetivo() {
        return valorObjetivo;
    }

    public void setValorObjetivo(double valorObjetivo) {
        this.valorObjetivo = valorObjetivo;
    }

    public double getValorActual() {
        return valorActual;
    }

    public void setValorActual(double valorActual) {
        this.valorActual = valorActual;
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

    public boolean isAlcanzado() {
        return alcanzado;
    }

    public void setAlcanzado(boolean alcanzado) {
        this.alcanzado = alcanzado;
    }

    public Users getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Users idUsuario) {
        this.idUsuario = idUsuario;
    }
}
