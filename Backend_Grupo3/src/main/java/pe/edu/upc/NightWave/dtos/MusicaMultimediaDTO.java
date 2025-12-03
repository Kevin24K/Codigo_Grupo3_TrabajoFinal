package pe.edu.upc.NightWave.dtos;

import jakarta.persistence.*;
import pe.edu.upc.NightWave.entities.TipoMusica;

public class MusicaMultimediaDTO
{
    private int idMusicaMultimedia;
    private String nombreMusica;
    private String linkArchivo;
    private TipoMusica idTipoMusica;

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
