package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Tipo_Musica")
public class TipoMusica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_tipo", length = 50, nullable = false)
    private String nombreTipo;

    @Column(name = "categoria", length = 30, nullable = false)
    private String categoria;

    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;

    // Constructor vacío
    public TipoMusica() {}

    public TipoMusica(int id, String nombreTipo, String categoria, String descripcion) {
        this.id = id;
        this.nombreTipo = nombreTipo;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
