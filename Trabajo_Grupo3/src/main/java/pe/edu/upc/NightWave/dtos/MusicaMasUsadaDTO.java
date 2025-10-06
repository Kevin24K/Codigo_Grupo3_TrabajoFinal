package pe.edu.upc.NightWave.dtos;

public class MusicaMasUsadaDTO
{
    public String nombreMusica;
    public int porcentajeUso;

    public String getNombreMusica() {
        return nombreMusica;
    }

    public void setNombreMusica(String nombreMusica) {
        this.nombreMusica = nombreMusica;
    }

    public int getPorcentajeUso() {
        return porcentajeUso;
    }

    public void setPorcentajeUso(int porcentajeUso) {
        this.porcentajeUso = porcentajeUso;
    }
}