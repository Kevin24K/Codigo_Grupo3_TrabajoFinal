package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Integraciones")
public class Integraciones
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIntegracion;

    @Column(name = "Dispositivo", length = 50, nullable = false)
    private String dispositivo;

    @Column(name = "Tipo", length = 50, nullable = false)
    private String tipo;

    @Column(name = "Estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "Fecha_Sincronizacion")
    private LocalDate fechaSincronizacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    public Integraciones() {}

    public Integraciones(int idIntegracion, String dispositivo, String tipo, String estado, LocalDate fechaSincronizacion, Usuario idUsuario) {
        this.idIntegracion = idIntegracion;
        this.dispositivo = dispositivo;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaSincronizacion = fechaSincronizacion;
        this.idUsuario = idUsuario;
    }

    public int getIdIntegracion() {
        return idIntegracion;
    }

    public void setIdIntegracion(int idIntegracion) {
        this.idIntegracion = idIntegracion;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaSincronizacion() {
        return fechaSincronizacion;
    }

    public void setFechaSincronizacion(LocalDate fechaSincronizacion) {
        this.fechaSincronizacion = fechaSincronizacion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
