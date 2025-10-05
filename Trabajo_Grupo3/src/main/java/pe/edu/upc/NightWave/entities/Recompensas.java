package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
<<<<<<< HEAD
@Table(name = "Recompensas")
=======
@Table(name = "Recompensa")
>>>>>>> origin/Gabriel
public class Recompensas
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecompensa;

<<<<<<< HEAD
    @Column(name = "nombre_recompensa", nullable = false, length = 100)
=======
    @Column(name = "nombreRecompensa", nullable = false, length = 100)
>>>>>>> origin/Gabriel
    private String nombreRecompensa;

    @Column(name = "descripcion",  nullable = false, length = 500)
    private String descripcion;

<<<<<<< HEAD
    @Column(name = "tipo_recompensa", nullable = false, length = 100)
    private String tipoRecompensa;

    @Column(name = "puntos_valor", nullable = false)
=======
    @Column(name = "tipoRecompensa", nullable = false, length = 100)
    private String tipoRecompensa;

    @Column(name = "puntosValor", nullable = false)
>>>>>>> origin/Gabriel
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
