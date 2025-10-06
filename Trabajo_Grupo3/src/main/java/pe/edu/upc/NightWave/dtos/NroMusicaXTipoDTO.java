package pe.edu.upc.NightWave.dtos;

public class NroMusicaXTipoDTO
{
    public String nombreTipo;
    public int nroMusica;

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public int getNroMusica() {
        return nroMusica;
    }

    public void setNroMusica(int nroMusica) {
        this.nroMusica = nroMusica;
    }
}