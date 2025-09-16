package pe.edu.upc.NightWave.dtos;

import pe.edu.upc.NightWave.entities.Sonido;

public class MeditacionesDTO
{
    private int idMeditacion;
    private String titulo;
    private String descripcion;
    private int duracion;
    private String nivelDificultad;
    private Sonido sonido;
    private String categoria;

    public int getIdMeditacion() {
        return idMeditacion;
    }

    public void setIdMeditacion(int idMeditacion) {
        this.idMeditacion = idMeditacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(String nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public Sonido getSonido() {
        return sonido;
    }

    public void setSonido(Sonido sonido) {
        this.sonido = sonido;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
