package pe.edu.upc.NightWave.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class TipoMusicaDTO
{
    private int idTipoMusica;
    private String nombreTipo;
    private String categoria;
    private String descripcion;

    public int getIdTipoMusica() {
        return idTipoMusica;
    }

    public void setIdTipoMusica(int idTipoMusica) {
        this.idTipoMusica = idTipoMusica;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
