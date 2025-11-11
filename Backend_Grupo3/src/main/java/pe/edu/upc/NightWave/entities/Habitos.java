package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Habito")
public class Habitos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHabitos;

    @Column(name = "nombreHabito", length = 100, nullable = false)
    private String nombreHabito;

    @Column(name = "descripcion", length = 300, nullable = false)
    private String descripcion;

    @Column(name = "categoria", length = 30, nullable = false)
    private String categoria;

    @Column(name = "momentoDia", length = 20, nullable = false)
    private String momentoDia;

    @Column(name = "activo", nullable = false)
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Users idUsuario;

    // Constructor vacío
    public Habitos() {}

    // Constructor completo

    public Habitos(int idHabitos, String nombreHabito, String descripcion, String categoria, String momentoDia, boolean activo, Users idUsuario) {
        this.idHabitos = idHabitos;
        this.nombreHabito = nombreHabito;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.momentoDia = momentoDia;
        this.activo = activo;
        this.idUsuario = idUsuario;
    }

    public int getIdHabitos() {
        return idHabitos;
    }

    public void setIdHabitos(int idHabitos) {
        this.idHabitos = idHabitos;
    }

    public String getNombreHabito() {
        return nombreHabito;
    }

    public void setNombreHabito(String nombreHabito) {
        this.nombreHabito = nombreHabito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMomentoDia() {
        return momentoDia;
    }

    public void setMomentoDia(String momentoDia) {
        this.momentoDia = momentoDia;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Users getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Users idUsuario) {
        this.idUsuario = idUsuario;
    }
}
