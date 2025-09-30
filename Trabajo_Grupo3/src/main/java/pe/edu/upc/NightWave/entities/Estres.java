package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Estres")
public class Estres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstres;

    @Column(name = "nivelEstres", nullable = false)
    private int nivelEstres;

    @Column(name = "nivelAnsiedad", nullable = false)
    private int nivelAnsiedad;

    @Column(name = "factoresEstimulantes", length = 200, nullable = false)
    private String factoresEstimulantes;

    @Column(name = "sintomasFisicos", length = 200, nullable = false)
    private String sintomasFisicos;

    @Column(name = "sintomasEmocionales", length = 200, nullable = false)
    private String sintomasEmocionales;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Users idUsuario;

    // Constructor vacío
    public Estres() {}

    // Constructor completo

    public Estres(int idEstres, int nivelEstres, int nivelAnsiedad, String factoresEstimulantes, String sintomasFisicos, String sintomasEmocionales, LocalDate fechaRegistro, Users idUsuario) {
        this.idEstres = idEstres;
        this.nivelEstres = nivelEstres;
        this.nivelAnsiedad = nivelAnsiedad;
        this.factoresEstimulantes = factoresEstimulantes;
        this.sintomasFisicos = sintomasFisicos;
        this.sintomasEmocionales = sintomasEmocionales;
        this.fechaRegistro = fechaRegistro;
        this.idUsuario = idUsuario;
    }

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
