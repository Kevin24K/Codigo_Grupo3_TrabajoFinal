package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Estres")
public class Estres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nivel_estres", nullable = false)
    private int nivelEstres;

    @Column(name = "nivel_ansiedad", nullable = false)
    private int nivelAnsiedad;

    @Column(name = "factores_estimulantes", length = 200, nullable = false)
    private String factoresEstimulantes;

    @Column(name = "sintomas_fisicos", length = 200, nullable = false)
    private String sintomasFisicos;

    @Column(name = "sintomas_emocionales", length = 200, nullable = false)
    private String sintomasEmocionales;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Constructor vacío
    public Estres() {}

    // Constructor completo
    public Estres(int id, int nivelEstres, int nivelAnsiedad, String factoresEstimulantes, String sintomasFisicos, String sintomasEmocionales, LocalDateTime fechaRegistro, Usuario usuario) {
        this.id = id;
        this.nivelEstres = nivelEstres;
        this.nivelAnsiedad = nivelAnsiedad;
        this.factoresEstimulantes = factoresEstimulantes;
        this.sintomasFisicos = sintomasFisicos;
        this.sintomasEmocionales = sintomasEmocionales;
        this.fechaRegistro = fechaRegistro;
        this.usuario = usuario;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
