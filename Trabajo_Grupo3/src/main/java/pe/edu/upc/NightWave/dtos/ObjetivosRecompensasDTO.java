package pe.edu.upc.NightWave.dtos;

import jakarta.persistence.*;
import pe.edu.upc.NightWave.entities.Objetivos;
import pe.edu.upc.NightWave.entities.Recompensas;

import java.time.LocalDateTime;

public class ObjetivosRecompensasDTO
{
    private int id;
    private LocalDateTime fechaObtencion;
    private Recompensas recompensa;
    private Objetivos objetivo;

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

