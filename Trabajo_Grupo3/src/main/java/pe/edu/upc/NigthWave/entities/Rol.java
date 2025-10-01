package pe.edu.upc.NigthWave.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idRol;

    @Column(name = "nombre_rol", length = 30, nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario user;


    public Rol() {
    }

    public Rol(int idRol, String nombre, Usuario user) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.user = user;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
