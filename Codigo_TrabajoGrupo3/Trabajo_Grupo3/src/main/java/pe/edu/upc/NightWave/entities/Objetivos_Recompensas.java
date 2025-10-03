package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Objetivos_Recompensas")
public class Objetivos_Recompensas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha_obtencion")
    private LocalDateTime fechaObtencion;

    @ManyToOne
    @JoinColumn(name = "recompensa_id", nullable = false)
    private Recompensas recompensa;

    @ManyToOne
    @JoinColumn(name = "objetivo_id", nullable = false)
    private Objetivos objetivo;

    public Objetivos_Recompensas() {
    }

    public Objetivos_Recompensas(int id, LocalDateTime fechaObtencion, Recompensas recompensa, Objetivos objetivo) {
        this.id = id;
        this.fechaObtencion = fechaObtencion;
        this.recompensa = recompensa;
        this.objetivo = objetivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaObtencion() {
        return fechaObtencion;
    }

    public void setFechaObtencion(LocalDateTime fechaObtencion) {
        this.fechaObtencion = fechaObtencion;
    }

    public Recompensas getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensas recompensa) {
        this.recompensa = recompensa;
    }

    public Objetivos getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivos objetivo) {
        this.objetivo = objetivo;
    }
}
