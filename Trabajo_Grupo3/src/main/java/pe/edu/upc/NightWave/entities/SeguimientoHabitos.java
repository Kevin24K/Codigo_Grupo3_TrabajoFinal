package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "SeguimientoHabito")
public class SeguimientoHabitos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSeguimientoHabitos;

    @Column(name = "completado", nullable = false)
    private boolean completado;

    @Column(name = "calidadEjecucion", nullable = false)
    private int calidadEjecucion;

    @Column(name = "notas", length = 200, nullable = false)
    private String notas;

    @Column(name = "fechaSeguimiento", nullable = false)
    private LocalDate fechaSeguimiento;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Users idUsuario;

    @ManyToOne
    @JoinColumn(name = "idHabito", nullable = false)
    private Habitos idHabito;

    // Constructor vacío
    public SeguimientoHabitos() {}

    // Constructor completo

    public SeguimientoHabitos(int idSeguimientoHabitos, boolean completado, int calidadEjecucion, String notas, LocalDate fechaSeguimiento, Users idUsuario, Habitos idHabito) {
        this.idSeguimientoHabitos = idSeguimientoHabitos;
        this.completado = completado;
        this.calidadEjecucion = calidadEjecucion;
        this.notas = notas;
        this.fechaSeguimiento = fechaSeguimiento;
        this.idUsuario = idUsuario;
        this.idHabito = idHabito;
    }

    public int getIdSeguimientoHabitos() {
        return idSeguimientoHabitos;
    }

    public void setIdSeguimientoHabitos(int idSeguimientoHabitos) {
        this.idSeguimientoHabitos = idSeguimientoHabitos;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public int getCalidadEjecucion() {
        return calidadEjecucion;
    }

    public void setCalidadEjecucion(int calidadEjecucion) {
        this.calidadEjecucion = calidadEjecucion;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public LocalDate getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public void setFechaSeguimiento(LocalDate fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public Users getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Users idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Habitos getIdHabito() {
        return idHabito;
    }

    public void setIdHabito(Habitos idHabito) {
        this.idHabito = idHabito;
    }
}
