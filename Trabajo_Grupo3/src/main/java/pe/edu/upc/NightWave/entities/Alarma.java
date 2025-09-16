package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "alarmas")
public class Alarma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlarma;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "hora_alarma", nullable = false)
    private java.time.LocalTime horaAlarma;

    @ManyToOne
    @JoinColumn(name = "id_sonido")
    private Sonido sonido;

    @Column(name = "dias_activos", length = 50)
    private String diasActivos;

    @Column(name = "activa")
    private boolean activa = true;

    public Alarma() {}

    public Alarma(Usuario usuario, int idAlarma, LocalTime horaAlarma, Sonido sonido, String diasActivos, boolean activa) {
        this.usuario = usuario;
        this.idAlarma = idAlarma;
        this.horaAlarma = horaAlarma;
        this.sonido = sonido;
        this.diasActivos = diasActivos;
        this.activa = activa;
    }

    public int getIdAlarma() {
        return idAlarma;
    }

    public void setIdAlarma(int idAlarma) {
        this.idAlarma = idAlarma;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sonido getSonido() {
        return sonido;
    }

    public void setSonido(Sonido sonido) {
        this.sonido = sonido;
    }

    public LocalTime getHoraAlarma() {
        return horaAlarma;
    }

    public void setHoraAlarma(LocalTime horaAlarma) {
        this.horaAlarma = horaAlarma;
    }

    public String getDiasActivos() {
        return diasActivos;
    }

    public void setDiasActivos(String diasActivos) {
        this.diasActivos = diasActivos;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
