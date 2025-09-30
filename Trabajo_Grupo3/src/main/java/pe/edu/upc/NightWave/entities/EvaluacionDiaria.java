package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "EvaluacionDiaria")
public class EvaluacionDiaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvaluacionDiaria;

    @Column(name = "estadoAnimo", length = 30, nullable = false)
    private String estadoAnimo;

    @Column(name = "nivelEnergia", nullable = false)
    private int nivelEnergia;

    @Column(name = "recomendaciones", length = 500, nullable = false)
    private String recomendaciones;

    @Column(name = "fechaEvaluacion", nullable = false)
    private LocalDate fechaEvaluacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Users idUsuario;

    // Constructor vacío
    public EvaluacionDiaria() {}

    // Constructor completo

    public EvaluacionDiaria(int idEvaluacionDiaria, String estadoAnimo, int nivelEnergia, String recomendaciones, LocalDate fechaEvaluacion, Users idUsuario) {
        this.idEvaluacionDiaria = idEvaluacionDiaria;
        this.estadoAnimo = estadoAnimo;
        this.nivelEnergia = nivelEnergia;
        this.recomendaciones = recomendaciones;
        this.fechaEvaluacion = fechaEvaluacion;
        this.idUsuario = idUsuario;
    }

    public int getIdEvaluacionDiaria() {
        return idEvaluacionDiaria;
    }

    public void setIdEvaluacionDiaria(int idEvaluacionDiaria) {
        this.idEvaluacionDiaria = idEvaluacionDiaria;
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

    public Users getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Users idUsuario) {
        this.idUsuario = idUsuario;
    }
}
