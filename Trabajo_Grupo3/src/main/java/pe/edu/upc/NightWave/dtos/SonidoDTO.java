package pe.edu.upc.NightWave.dtos;

public class SonidoDTO
{

    private int idSonido;
    private String nombre;
    private String tipo;
    private String urlArchivo;
    private int duracion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdSonido() {
        return idSonido;
    }

    public void setIdSonido(int idSonido) {
        this.idSonido = idSonido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}