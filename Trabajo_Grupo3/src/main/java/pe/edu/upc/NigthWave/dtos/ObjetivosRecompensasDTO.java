package pe.edu.upc.NigthWave.dtos;

import java.time.LocalDateTime;

public class ObjetivosRecompensasDTO
{
    private int id;
    private LocalDateTime fechaObtencion;
    private int IdRecompensa;
    private int IdOjetivo;

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

    public int getIdOjetivo() {
        return IdOjetivo;
    }

    public void setIdOjetivo(int idOjetivo) {
        IdOjetivo = idOjetivo;
    }

    public int getIdRecompensa() {
        return IdRecompensa;
    }

    public void setIdRecompensa(int idRecompensa) {
        IdRecompensa = idRecompensa;
    }

}

