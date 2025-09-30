package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ObjetivosRecompensa")
public class ObjetivosRecompensas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idObjetivosRecompensas;

    @Column(name = "fechaObtencion", nullable = false)
    private LocalDate fechaObtencion;

    @ManyToOne
    @JoinColumn(name = "idRecompensa", nullable = false)
    private Recompensas idRecompensa;

    @ManyToOne
    @JoinColumn(name = "idObjetivo", nullable = false)
    private Objetivos idObjetivo;

    // Constructor vacío
    public ObjetivosRecompensas() {}

    // Constructor completo

    public ObjetivosRecompensas(int idObjetivosRecompensas, LocalDate fechaObtencion, Recompensas idRecompensa, Objetivos idObjetivo) {
        this.idObjetivosRecompensas = idObjetivosRecompensas;
        this.fechaObtencion = fechaObtencion;
        this.idRecompensa = idRecompensa;
        this.idObjetivo = idObjetivo;
    }

    public int getIdObjetivosRecompensas() {
        return idObjetivosRecompensas;
    }

    public void setIdObjetivosRecompensas(int idObjetivosRecompensas) {
        this.idObjetivosRecompensas = idObjetivosRecompensas;
    }

    public LocalDate getFechaObtencion() {
        return fechaObtencion;
    }

    public void setFechaObtencion(LocalDate fechaObtencion) {
        this.fechaObtencion = fechaObtencion;
    }

    public Recompensas getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(Recompensas idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public Objetivos getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(Objetivos idObjetivo) {
        this.idObjetivo = idObjetivo;
    }
}
