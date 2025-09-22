package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Habitos")
public class Habitos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_habito", length = 100, nullable = false)
    private String nombreHabito;

    @Column(name = "descripcion", length = 300, nullable = false)
    private String descripcion;

    @Column(name = "categoria", length = 30, nullable = false)
    private String categoria;

    @Column(name = "momento_dia", length = 20, nullable = false)
    private String momentoDia;

    @Column(name = "activo", nullable = false)
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Constructor vacío
    public Habitos() {}

    // Constructor completo
    public Habitos(int id, String nombreHabito, String descripcion, String categoria, String momentoDia, boolean activo, Usuario usuario) {
        this.id = id;
        this.nombreHabito = nombreHabito;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.momentoDia = momentoDia;
        this.activo = activo;
        this.usuario = usuario;
    }

    // Getters y Setters
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
