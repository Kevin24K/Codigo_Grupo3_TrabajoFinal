package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Evaluacion_Diaria")
public class EvaluacionDiaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado_animo", length = 30, nullable = false)
    private String estadoAnimo;

    @Column(name = "nivel_energia", nullable = false)
    private int nivelEnergia;

    @Column(name = "recomendaciones", length = 500, nullable = false)
    private String recomendaciones;

    @Column(name = "fecha_evaluacion", nullable = false)
    private LocalDate fechaEvaluacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Constructor vacío
    public EvaluacionDiaria() {}

    // Constructor completo
    public EvaluacionDiaria(int id, String estadoAnimo, int nivelEnergia, String recomendaciones, LocalDate fechaEvaluacion, Usuario usuario) {
        this.id = id;
        this.estadoAnimo = estadoAnimo;
        this.nivelEnergia = nivelEnergia;
        this.recomendaciones = recomendaciones;
        this.fechaEvaluacion = fechaEvaluacion;
        this.usuario = usuario;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstadoAnimo() {
        return estadoAnimo;
    }

    public void setEstadoAnimo(String estadoAnimo) {
        this.estadoAnimo = estadoAnimo;
    }

    public int getNivelEnergia() {
        return nivelEnergia;
    }

    public void setNivelEnergia(int nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
