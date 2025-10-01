package pe.edu.upc.NigthWave.dtos;

import java.time.LocalDateTime;

public class EstresDTO
{

    private int id;
    private int nivelEstres;
    private int nivelAnsiedad;
    private String factoresEstimulantes;
    private String sintomasFisicos;
    private String sintomasEmocionales;
    private LocalDateTime fechaRegistro;
    private int IdUsuario;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getSintomasEmocionales() {
        return sintomasEmocionales;
    }

    public void setSintomasEmocionales(String sintomasEmocionales) {
        this.sintomasEmocionales = sintomasEmocionales;
    }

    public String getSintomasFisicos() {
        return sintomasFisicos;
    }

    public void setSintomasFisicos(String sintomasFisicos) {
        this.sintomasFisicos = sintomasFisicos;
    }

    public String getFactoresEstimulantes() {
        return factoresEstimulantes;
    }

    public void setFactoresEstimulantes(String factoresEstimulantes) {
        this.factoresEstimulantes = factoresEstimulantes;
    }

    public int getNivelAnsiedad() {
        return nivelAnsiedad;
    }

    public void setNivelAnsiedad(int nivelAnsiedad) {
        this.nivelAnsiedad = nivelAnsiedad;
    }

    public int getNivelEstres() {
        return nivelEstres;
    }

    public void setNivelEstres(int nivelEstres) {
        this.nivelEstres = nivelEstres;
    }
}

