package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "seguimiento_habitos")
public class SeguimientoHabitos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_habito", length = 100, nullable = false)
    private String nombreHabito;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "estado_cumplimiento", nullable = false)
    private Boolean estadoCumplimiento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public SeguimientoHabitos() {
    }

    public SeguimientoHabitos(int id, String nombreHabito, LocalDate fechaRegistro, Boolean estadoCumplimiento, Usuario usuario) {
        this.id = id;
        this.nombreHabito = nombreHabito;
        this.fechaRegistro = fechaRegistro;
        this.estadoCumplimiento = estadoCumplimiento;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreHabito() {
        return nombreHabito;
    }

    public void setNombreHabito(String nombreHabito) {
        this.nombreHabito = nombreHabito;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Boolean getEstadoCumplimiento() {
        return estadoCumplimiento;
    }

    public void setEstadoCumplimiento(Boolean estadoCumplimiento) {
        this.estadoCumplimiento = estadoCumplimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
