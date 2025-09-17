package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Estres")
public class Estres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstres;
    //Nivel de estres BAJO MEDIO ALTO
    @Column(name = "fechaRegistro",nullable = false, length = 50)
    private String nivelEstres;
    //Nivel de ansiedad BAJO MEDIO ALTO
    @Column(name = "nivelAnsiedad",nullable = false, length = 50)
    private String nivelAnsiedad;
    @Column(name = "factoresEstimulantes",nullable = false, length = 50)
    private String factoresEstimulantes;
    @Column(name = "sintomasFisicos",nullable = false, length = 100)
    private String sintomasFisicos;
    @Column(name = "sintomasEmocionales",nullable = false, length = 100)
    private String sintomasEmocionales;
    @Column(name = "fechaRegistro",nullable = false)
    private LocalDate fechaRegistro;
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public Estres() {}

    public Estres(int idEstres, String nivelEstres, String nivelAnsiedad, String factoresEstimulantes, String sintomasFisicos, String sintomasEmocionales, LocalDate fechaRegistro, Usuario usuario) {
        this.idEstres = idEstres;
        this.nivelEstres = nivelEstres;
        this.nivelAnsiedad = nivelAnsiedad;
        this.factoresEstimulantes = factoresEstimulantes;
        this.sintomasFisicos = sintomasFisicos;
        this.sintomasEmocionales = sintomasEmocionales;
        this.fechaRegistro = fechaRegistro;
        this.usuario = usuario;
    }

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
