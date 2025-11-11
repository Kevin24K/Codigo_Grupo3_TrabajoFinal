package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "MusicaMultimedia")
public class MusicaMultimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMusicaMultimedia;

    @Column(name = "nombreMusica", length = 200, nullable = false)
    private String nombreMusica;

    @Column(name = "linkArchivo", length = 500, nullable = false)
    private String linkArchivo;

    @ManyToOne
    @JoinColumn(name = "idTipoMusica", nullable = false)
    private TipoMusica idTipoMusica;

    // Constructor vacío
    public MusicaMultimedia() {}

    public MusicaMultimedia(int idMusicaMultimedia, String nombreMusica, String linkArchivo, TipoMusica idTipoMusica) {
        this.idMusicaMultimedia = idMusicaMultimedia;
        this.nombreMusica = nombreMusica;
        this.linkArchivo = linkArchivo;
        this.idTipoMusica = idTipoMusica;
    }

    public int getIdMusicaMultimedia() {
        return idMusicaMultimedia;
    }

    public void setIdMusicaMultimedia(int idMusicaMultimedia) {
        this.idMusicaMultimedia = idMusicaMultimedia;
    }

    public String getNombreMusica() {
        return nombreMusica;
    }

    public void setNombreMusica(String nombreMusica) {
        this.nombreMusica = nombreMusica;
    }

    public String getLinkArchivo() {
        return linkArchivo;
    }

    public void setLinkArchivo(String linkArchivo) {
        this.linkArchivo = linkArchivo;
    }

    public TipoMusica getIdTipoMusica() {
        return idTipoMusica;
    }

    public void setIdTipoMusica(TipoMusica idTipoMusica) {
        this.idTipoMusica = idTipoMusica;
    }
}
