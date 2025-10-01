package pe.edu.upc.NigthWave.dtos;

public class RecompensasDTO
{
    private int idRecompensa;
    private String nombreRecompensa;
    private String descripcion;
    private String tipoRecompensa;
    private int puntosValor;

    public int getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(int idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreRecompensa() {
        return nombreRecompensa;
    }

    public void setNombreRecompensa(String nombreRecompensa) {
        this.nombreRecompensa = nombreRecompensa;
    }

    public String getTipoRecompensa() {
        return tipoRecompensa;
    }

    public void setTipoRecompensa(String tipoRecompensa) {
        this.tipoRecompensa = tipoRecompensa;
    }

    public int getPuntosValor() {
        return puntosValor;
    }

    public void setPuntosValor(int puntosValor) {
        this.puntosValor = puntosValor;
    }

}
