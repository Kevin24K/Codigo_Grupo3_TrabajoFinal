package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 50, nullable = false)
    private String apellido;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDateTime fechaNacimiento;

    @Column(name = "genero", length = 20, nullable = false)
    private String genero;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    @Column(name = "activo", nullable = false)
    private boolean activo;

    // Constructor vacío
    public Usuario() {}

    public Usuario(int id, String nombre, String apellido, String email, String password, LocalDateTime fechaNacimiento, String genero, Rol rol, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.rol = rol;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
