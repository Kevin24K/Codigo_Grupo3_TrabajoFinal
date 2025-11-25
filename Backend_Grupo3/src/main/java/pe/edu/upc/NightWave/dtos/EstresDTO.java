package pe.edu.upc.NightWave.dtos;

import pe.edu.upc.NightWave.entities.Users;

import java.time.LocalDate;

public class EstresDTO
{
    private int idEstres;
    private int nivelEstres;
    private int nivelAnsiedad;
    private String factoresEstimulantes;
    private String sintomasFisicos;
    private String sintomasEmocionales;
    private LocalDate fechaRegistro;
    private Users idUsuario;

    public int getIdEstres() {
        return idEstres;
    }

    public void setIdEstres(int idEstres) {
        this.idEstres = idEstres;
    }

    public int getNivelEstres() {
        return nivelEstres;
    }

    public void setNivelEstres(int nivelEstres) {
        this.nivelEstres = nivelEstres;
    }

    public int getNivelAnsiedad() {
        return nivelAnsiedad;
    }

    public void setNivelAnsiedad(int nivelAnsiedad) {
        this.nivelAnsiedad = nivelAnsiedad;
    }

    public String getFactoresEstimulantes() {
        return factoresEstimulantes;
    }

    public void setFactoresEstimulantes(String factoresEstimulantes) {
        this.factoresEstimulantes = factoresEstimulantes;
    }

    public String getSintomasFisicos() {
        return sintomasFisicos;
    }

    public void setSintomasFisicos(String sintomasFisicos) {
        this.sintomasFisicos = sintomasFisicos;
    }

    public String getSintomasEmocionales() {
        return sintomasEmocionales;
    }

    public void setSintomasEmocionales(String sintomasEmocionales) {
        this.sintomasEmocionales = sintomasEmocionales;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Users getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Users idUsuario) {
        this.idUsuario = idUsuario;
    }
}

