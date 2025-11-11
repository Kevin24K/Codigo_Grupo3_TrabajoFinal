package pe.edu.upc.NightWave.dtos;

import jakarta.persistence.*;
import pe.edu.upc.NightWave.entities.Objetivos;
import pe.edu.upc.NightWave.entities.Recompensas;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ObjetivosRecompensasDTO
{
    private int idObjetivosRecompensas;
    private LocalDate fechaObtencion;
    private Recompensas idRecompensa;
    private Objetivos idObjetivo;

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

