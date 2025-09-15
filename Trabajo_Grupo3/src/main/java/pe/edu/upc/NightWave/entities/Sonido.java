package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

@Entity
@Table(name="sonidos")
public class Sonido
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idSonido;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;
    @Column(name="url_archivo", nullable = false, length = 250)
    private String urlArchivo;
    @Column(name="duracion", nullable = false)
    private int duracion;

    public Sonido() {}

    public int getIdSonido() {
        return idSonido;
    }

    public void setIdSonido(int idSonido) {
        this.idSonido = idSonido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
