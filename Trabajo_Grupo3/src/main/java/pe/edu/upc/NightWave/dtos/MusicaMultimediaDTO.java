package pe.edu.upc.NightWave.dtos;

import jakarta.persistence.*;
import pe.edu.upc.NightWave.entities.TipoMusica;

public class MusicaMultimediaDTO
{
    private int id;
    private String nombre;
    private String linkArchivo;
    private TipoMusica tipoMusica;

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
