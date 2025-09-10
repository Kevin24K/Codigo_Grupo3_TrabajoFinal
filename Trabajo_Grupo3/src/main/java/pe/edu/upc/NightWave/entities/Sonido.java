package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Sonidos")
public class Sonido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idSonido;
    @Column(name = "tipoSonido",nullable = false,length = 50)
    private String tipoSonido;
    @Column(name = "descripcion",nullable = false,length = 200)
    private String descripcion;

    public Sonido() {}

    public Sonido(int idSonido, String tipoSonido, String descripcion) {
        this.idSonido = idSonido;
        this.tipoSonido = tipoSonido;
        this.descripcion = descripcion;
    }

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
