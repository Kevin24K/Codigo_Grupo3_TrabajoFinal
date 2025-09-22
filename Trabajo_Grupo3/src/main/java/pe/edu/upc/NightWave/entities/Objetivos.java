package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Objetivos")
public class Objetivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_objetivo", length = 200, nullable = false)
    private String nombreObjetivo;

    @Column(name = "tipo_objetivo", length = 50, nullable = false)
    private String tipoObjetivo;

    @Column(name = "descripcion", length = 300, nullable = false)
    private String descripcion;

    @Column(name = "valor_objetivo", nullable = false)
    private double valorObjetivo;

    @Column(name = "valor_actual", nullable = false)
    private double valorActual;

    @Column(name = "unidad_medida", length = 20, nullable = false)
    private String unidadMedida;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fechaFin;

    @Column(name = "alcanzado", nullable = false)
    private boolean alcanzado;

    @Column(name = "fecha_logro", nullable = false)
    private LocalDateTime fechaLogro;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Constructor vacío
    public Objetivos() {}

    // Constructor completo
    public Objetivos(int id, String nombreObjetivo, String tipoObjetivo, String descripcion, double valorObjetivo,
                     double valorActual, String unidadMedida, LocalDateTime fechaInicio, LocalDateTime fechaFin,
                     boolean alcanzado, LocalDateTime fechaLogro, Usuario usuario) {
        this.id = id;
        this.nombreObjetivo = nombreObjetivo;
        this.tipoObjetivo = tipoObjetivo;
        this.descripcion = descripcion;
        this.valorObjetivo = valorObjetivo;
        this.valorActual = valorActual;
        this.unidadMedida = unidadMedida;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.alcanzado = alcanzado;
        this.fechaLogro = fechaLogro;
        this.usuario = usuario;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
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

    public boolean isAlcanzado() {
        return alcanzado;
    }

    public void setAlcanzado(boolean alcanzado) {
        this.alcanzado = alcanzado;
    }

    public LocalDateTime getFechaLogro() {
        return fechaLogro;
    }

    public void setFechaLogro(LocalDateTime fechaLogro) {
        this.fechaLogro = fechaLogro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
