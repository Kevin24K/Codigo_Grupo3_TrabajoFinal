package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Recompensa")
public class Recompensas
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecompensa;

    @Column(name = "nombreRecompensa", nullable = false, length = 100)
    private String nombreRecompensa;

    @Column(name = "descripcion",  nullable = false, length = 500)
    private String descripcion;

    @Column(name = "tipoRecompensa", nullable = false, length = 100)
    private String tipoRecompensa;

    @Column(name = "puntosValor", nullable = false)
    private int puntosValor;

    public Recompensas () {}

    public Recompensas(int idRecompensa, String nombreRecompensa, String descripcion, String tipoRecompensa, int puntosValor )
    {
        this.idRecompensa = idRecompensa;
        this.nombreRecompensa = nombreRecompensa;
        this.descripcion = descripcion;
        this.tipoRecompensa = tipoRecompensa;
        this.puntosValor = puntosValor;
    }

    public int getIdRecompensa() {return idRecompensa;}

    public void setIdRecompensa(int idRecompensa) {this.idRecompensa = idRecompensa;}

    public String getNombreRecompensa() {return nombreRecompensa;}

    public void setNombreRecompensa(String  nombreRecompensa) {this.nombreRecompensa = nombreRecompensa;}

    public String getDescripcionRecompensa() {return descripcion;}

    public void setDescripcionRecompensa(String descripcion) {this.descripcion = descripcion;}

    public String getTipoRecompensa() {return tipoRecompensa;}

    public void setTipoRecompensa(String tipoRecompensa) {this.tipoRecompensa = tipoRecompensa;}

    public int getPuntosValorReompensa() {return puntosValor;}

    public void setPuntosValorRecompensa(int  puntosValor) {this.puntosValor = puntosValor;}
}
