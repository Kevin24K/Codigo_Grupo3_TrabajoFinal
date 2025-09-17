package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Integracion")
public class Integracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIntegracion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "proveedor", length = 100, nullable = false)
    private String proveedor;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    @Column(name = "token_acceso", length = 500, nullable = false)
    private String tokenAcceso;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "activo")
    private boolean activo;

    public Integracion() {}

    public Integracion(int idIntegracion, Usuario usuario, String proveedor, String tipo, String tokenAcceso, LocalDateTime fechaRegistro, boolean activo) {
        this.idIntegracion = idIntegracion;
        this.usuario = usuario;
        this.proveedor = proveedor;
        this.tipo = tipo;
        this.tokenAcceso = tokenAcceso;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
    }

    // Getters y Setters


    public int getIdIntegracion() {
        return idIntegracion;
    }

    public void setIdIntegracion(int idIntegracion) {
        this.idIntegracion = idIntegracion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTokenAcceso() {
        return tokenAcceso;
    }

    public void setTokenAcceso(String tokenAcceso) {
        this.tokenAcceso = tokenAcceso;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
