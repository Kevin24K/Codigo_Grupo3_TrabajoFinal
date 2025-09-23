package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Sueno")
public class Sueno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "hora_acostarse", nullable = false)
    private LocalDateTime horaAcostarse;

    @Column(name = "hora_despertar", nullable = false)
    private LocalDateTime horaDespertar;

    @Column(name = "calidad_sueno", nullable = false)
    private int calidadSueno;

    @Column(name = "interrupciones", nullable = false)
    private int interrupciones;

    @Column(name = "cafeina_consumida", nullable = false)
    private boolean cafeinaConsumida;

    @Column(name = "ejercicio_realizado", nullable = false)
    private boolean ejercicioRealizado;

    @Column(name = "pantallas_antes_dormir", nullable = false)
    private boolean pantallasAntesDormir;

    @Column(name = "nivel_estres_dia", nullable = false)
    private int nivelEstresDia;

    @Column(name = "notas", length = 300, nullable = false)
    private String notas;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Constructor vacío
    public Sueno() {}

    // Constructor completo
    public Sueno(int id, LocalDateTime fechaRegistro, LocalDateTime horaAcostarse, LocalDateTime horaDespertar,
                 int calidadSueno, int interrupciones, boolean cafeinaConsumida,
                 boolean ejercicioRealizado, boolean pantallasAntesDormir, int nivelEstresDia, String notas,
                 Usuario usuario) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.horaAcostarse = horaAcostarse;
        this.horaDespertar = horaDespertar;
        this.calidadSueno = calidadSueno;
        this.interrupciones = interrupciones;
        this.cafeinaConsumida = cafeinaConsumida;
        this.ejercicioRealizado = ejercicioRealizado;
        this.pantallasAntesDormir = pantallasAntesDormir;
        this.nivelEstresDia = nivelEstresDia;
        this.notas = notas;
        this.usuario = usuario;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getHoraAcostarse() {
        return horaAcostarse;
    }

    public void setHoraAcostarse(LocalDateTime horaAcostarse) {
        this.horaAcostarse = horaAcostarse;
    }

    public LocalDateTime getHoraDespertar() {
        return horaDespertar;
    }

    public void setHoraDespertar(LocalDateTime horaDespertar) {
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

    public boolean isEjercicioRealizado() {
        return ejercicioRealizado;
    }

    public void setEjercicioRealizado(boolean ejercicioRealizado) {
        this.ejercicioRealizado = ejercicioRealizado;
    }

    public boolean isPantallasAntesDormir() {
        return pantallasAntesDormir;
    }

    public void setPantallasAntesDormir(boolean pantallasAntesDormir) {
        this.pantallasAntesDormir = pantallasAntesDormir;
    }

    public int getNivelEstresDia() {
        return nivelEstresDia;
    }

    public void setNivelEstresDia(int nivelEstresDia) {
        this.nivelEstresDia = nivelEstresDia;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
