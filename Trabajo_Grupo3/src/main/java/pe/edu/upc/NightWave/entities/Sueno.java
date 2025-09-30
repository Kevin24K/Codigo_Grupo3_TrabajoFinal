package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Sueno")
public class Sueno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSueno;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "horaAcostarse", nullable = false)
    private LocalDate horaAcostarse;

    @Column(name = "horaDespertar", nullable = false)
    private LocalDate horaDespertar;

    @Column(name = "calidadSueno", nullable = false)
    private int calidadSueno;

    @Column(name = "interrupciones", nullable = false)
    private int interrupciones;

    @Column(name = "cafeinaConsumida", nullable = false)
    private boolean cafeinaConsumida;

    @Column(name = "notas", length = 300, nullable = false)
    private String notas;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Users idUsuario;

    // Constructor vacío
    public Sueno() {}

    // Constructor completo

    public Sueno(int idSueno, LocalDate fechaRegistro, LocalDate horaAcostarse, LocalDate horaDespertar, int calidadSueno, int interrupciones, boolean cafeinaConsumida, String notas, Users idUsuario) {
        this.idSueno = idSueno;
        this.fechaRegistro = fechaRegistro;
        this.horaAcostarse = horaAcostarse;
        this.horaDespertar = horaDespertar;
        this.calidadSueno = calidadSueno;
        this.interrupciones = interrupciones;
        this.cafeinaConsumida = cafeinaConsumida;
        this.notas = notas;
        this.idUsuario = idUsuario;
    }

    public int getIdSueno() {
        return idSueno;
    }

    public void setIdSueno(int idSueno) {
        this.idSueno = idSueno;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getHoraAcostarse() {
        return horaAcostarse;
    }

    public void setHoraAcostarse(LocalDate horaAcostarse) {
        this.horaAcostarse = horaAcostarse;
    }

    public LocalDate getHoraDespertar() {
        return horaDespertar;
    }

    public void setHoraDespertar(LocalDate horaDespertar) {
        this.horaDespertar = horaDespertar;
    }

    public int getCalidadSueno() {
        return calidadSueno;
    }

    public void setCalidadSueno(int calidadSueno) {
        this.calidadSueno = calidadSueno;
    }

    public int getInterrupciones() {
        return interrupciones;
    }

    public void setInterrupciones(int interrupciones) {
        this.interrupciones = interrupciones;
    }

    public boolean isCafeinaConsumida() {
        return cafeinaConsumida;
    }

    public void setCafeinaConsumida(boolean cafeinaConsumida) {
        this.cafeinaConsumida = cafeinaConsumida;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Users getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Users idUsuario) {
        this.idUsuario = idUsuario;
    }
}
