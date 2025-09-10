package pe.edu.upc.NightWave.dtos;


public class SonidoDTO {
    private int idSonido;
    private String tipoSonido;
    private String descripcion;

    public int getIdSonido() {
        return idSonido;
    }

    public void setIdSonido(int idSonido) {
        this.idSonido = idSonido;
    }

    public String getTipoSonido() {
        return tipoSonido;
    }

    public void setTipoSonido(String tipoSonido) {
        this.tipoSonido = tipoSonido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
