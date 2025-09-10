package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Recompensas")
public class Recompensas
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecompensa;

    @Column(name = "nombre_recompensa", nullable = false, length = 100)
    private String nombreRecompensa;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String Descripcion;

    @Column(name = "tipo_recompensa", nullable = false, length = 50)
    private String tipoRecompensa;

    @ManyToOne
    @JoinColumn(name = "IDUsuario")
    private Usuario usuario;

    public Recompensas() {
    }

    public Recompensas(int idRecompensa, String nombreRecompensa, String descripcion, String tipoRecompensa, Usuario usuario) {
        this.idRecompensa = idRecompensa;
        this.nombreRecompensa = nombreRecompensa;
        Descripcion = descripcion;
        this.tipoRecompensa = tipoRecompensa;
        this.usuario = usuario;
    }

    public int getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(int idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public String getNombreRecompensa() {
        return nombreRecompensa;
    }

    public void setNombreRecompensa(String nombreRecompensa) {
        this.nombreRecompensa = nombreRecompensa;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getTipoRecompensa() {
        return tipoRecompensa;
    }

    public void setTipoRecompensa(String tipoRecompensa) {
        this.tipoRecompensa = tipoRecompensa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
