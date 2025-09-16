package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Meditaciones")
public class Meditaciones
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMeditacion;

    @Column(name = "Titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "Duracion", nullable = false, length = 50)
    private int duracion;

    @Column(name = "Nivel_Dificulad",  nullable = false, length = 50)
    private String nivelDificultad;

    @Column(name = "Categoria",  nullable = false, length = 50)
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "id_Sonido")
    private Sonido idSonido;

    public  Meditaciones() {}

    public Meditaciones(int idMeditacion, String titulo, String descripcion, int duracion, String nivelDificultad, String categoria, Sonido idSonido) {
        this.idMeditacion = idMeditacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.nivelDificultad = nivelDificultad;
        this.categoria = categoria;
        this.idSonido = idSonido;
    }

    public int getIdMeditacion() {
        return idMeditacion;
    }

    public void setIdMeditacion(int idMeditacion) {
        this.idMeditacion = idMeditacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(String nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Sonido getIdSonido() {
        return idSonido;
    }

    public void setIdSonido(Sonido idSonido) {
        this.idSonido = idSonido;
    }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
