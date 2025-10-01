package pe.edu.upc.NigthWave.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Seguimiento_Habitos")
public class SeguimientoHabitos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "completado", nullable = false)
    private boolean completado;

    @Column(name = "calidad_ejecucion", nullable = false)
    private int calidadEjecucion;

    @Column(name = "notas", length = 200, nullable = false)
    private String notas;

    @Column(name = "fecha_seguimiento", nullable = false)
    private LocalDateTime fechaSeguimiento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "habito_id", nullable = false)
    private Habitos habito;

    // Constructor vacío
    public SeguimientoHabitos() {}

    // Constructor completo
    public SeguimientoHabitos(int id, boolean completado, int calidadEjecucion, String notas, LocalDateTime fechaSeguimiento, Usuario usuario, Habitos habito) {
        this.id = id;
        this.completado = completado;
        this.calidadEjecucion = calidadEjecucion;
        this.notas = notas;
        this.fechaSeguimiento = fechaSeguimiento;
        this.usuario = usuario;
        this.habito = habito;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public void setFechaSeguimiento(LocalDateTime fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Habitos getHabito() {
        return habito;
    }

    public void setHabito(Habitos habito) {
        this.habito = habito;
    }
}
