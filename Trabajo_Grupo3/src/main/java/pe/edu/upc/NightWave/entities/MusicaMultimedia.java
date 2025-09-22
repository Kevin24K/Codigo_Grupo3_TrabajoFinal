package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Musica_Multimedia")
public class MusicaMultimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;

    @Column(name = "link_archivo", length = 500, nullable = false)
    private String linkArchivo;

    @ManyToOne
    @JoinColumn(name = "tipo_musica_id", nullable = false)
    private TipoMusica tipoMusica;

    // Constructor vacío
    public MusicaMultimedia() {}

    public MusicaMultimedia(int id, String nombre, String linkArchivo, TipoMusica tipoMusica) {
        this.id = id;
        this.nombre = nombre;
        this.linkArchivo = linkArchivo;
        this.tipoMusica = tipoMusica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLinkArchivo() {
        return linkArchivo;
    }

    public void setLinkArchivo(String linkArchivo) {
        this.linkArchivo = linkArchivo;
    }

    public TipoMusica getTipoMusica() {
        return tipoMusica;
    }

    public void setTipoMusica(TipoMusica tipoMusica) {
        this.tipoMusica = tipoMusica;
    }
}
