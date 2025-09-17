package pe.edu.upc.NightWave.dtos;

import pe.edu.upc.NightWave.entities.Usuario;

import java.time.LocalDate;

public class EstresDTO {
    private int idEstres;
    private String nivelEstres;
    private String nivelAnsiedad;
    private String factoresEstimulantes;
    private String sintomasFisicos;
    private String sintomasEmocionales;
    private LocalDate fechaRegistro;
    private Usuario usuario;

    public int getIdEstres() {
        return idEstres;
    }

    public void setIdEstres(int idEstres) {
        this.idEstres = idEstres;
    }

    public String getNivelEstres() {
        return nivelEstres;
    }

    public void setNivelEstres(String nivelEstres) {
        this.nivelEstres = nivelEstres;
    }

    public String getNivelAnsiedad() {
        return nivelAnsiedad;
    }

    public void setNivelAnsiedad(String nivelAnsiedad) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
