package pe.edu.upc.NightWave.dtos;

import jakarta.persistence.*;
import pe.edu.upc.NightWave.entities.Usuario;

import java.time.LocalDateTime;

public class EvaluacionDiariaDTO
{

    private int id;
    private String estadoAnimo;
    private int nivelEnergia;
    private String recomendaciones;
    private LocalDateTime fechaEvaluacion;
    private Usuario usuario;

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

    public LocalDateTime getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDateTime fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

