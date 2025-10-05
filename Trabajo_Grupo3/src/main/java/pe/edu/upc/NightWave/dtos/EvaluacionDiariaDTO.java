package pe.edu.upc.NightWave.dtos;

import pe.edu.upc.NightWave.entities.Users;

import java.time.LocalDate;

public class EvaluacionDiariaDTO
{

    private int idEvaluacionDiaria;
    private String estadoAnimo;
    private int nivelEnergia;
    private String recomendaciones;
    private LocalDate fechaEvaluacion;
    private Users idUsuario;

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

