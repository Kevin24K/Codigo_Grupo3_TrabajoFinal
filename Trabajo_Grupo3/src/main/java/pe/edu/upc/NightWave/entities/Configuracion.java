package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "configuracion")
public class Configuracion
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConfiguracion;

    @Column(name = "modo_sin_distracciones", nullable = false)
    private boolean modoSinDistracciones = false;

    @Column(name = "modo_nocturno", nullable = false)
    private boolean modoNocturno = false;

    @Column(name = "modo_avion", nullable = false)
    private boolean modoAvion = false;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Configuracion() {}

    public Configuracion(int idConfiguracion, boolean modoSinDistracciones, boolean modoNocturno, Usuario usuario, boolean modoAvion) {
        this.idConfiguracion = idConfiguracion;
        this.modoSinDistracciones = modoSinDistracciones;
        this.modoNocturno = modoNocturno;
        this.usuario = usuario;
        this.modoAvion = modoAvion;
    }

    public int getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(int idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public boolean isModoSinDistracciones() {
        return modoSinDistracciones;
    }

    public void setModoSinDistracciones(boolean modoSinDistracciones) {
        this.modoSinDistracciones = modoSinDistracciones;
    }

    public boolean isModoNocturno() {
        return modoNocturno;
    }

    public void setModoNocturno(boolean modoNocturno) {
        this.modoNocturno = modoNocturno;
    }

    public boolean isModoAvion() {
        return modoAvion;
    }

    public void setModoAvion(boolean modoAvion) {
        this.modoAvion = modoAvion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
