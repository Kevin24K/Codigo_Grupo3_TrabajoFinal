package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "Alarma")
public class Alarma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlarma;

    @Column(name = "nombreAlarma", length = 100, nullable = false)
    private String nombreAlarma;

    @Column(name = "horaAlarma", nullable = false)
    private LocalTime horaAlarma;

    @Column(name = "diasSemana", length = 50, nullable = false)
    private String diasSemana;

    @Column(name = "activa", nullable = false)
    private boolean activa;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Users idUsuario;

    @ManyToOne
    @JoinColumn(name = "idMusicaMultimedia", nullable = false)
    private MusicaMultimedia idMusicaMultimedia;

    // Constructor vacío
    public Alarma() {}

    // Constructor completo

    public Alarma(int idAlarma, String nombreAlarma, LocalTime horaAlarma, String diasSemana, boolean activa, Users idUsuario, MusicaMultimedia idMusicaMultimedia) {
        this.idAlarma = idAlarma;
        this.nombreAlarma = nombreAlarma;
        this.horaAlarma = horaAlarma;
        this.diasSemana = diasSemana;
        this.activa = activa;
        this.idUsuario = idUsuario;
        this.idMusicaMultimedia = idMusicaMultimedia;
    }

    public int getIdAlarma() {
        return idAlarma;
    }

    public void setIdAlarma(int idAlarma) {
        this.idAlarma = idAlarma;
    }

    public String getNombreAlarma() {
        return nombreAlarma;
    }

    public void setNombreAlarma(String nombreAlarma) {
        this.nombreAlarma = nombreAlarma;
    }

    public LocalTime getHoraAlarma() {
        return horaAlarma;
    }

    public void setHoraAlarma(LocalTime horaAlarma) {
        this.horaAlarma = horaAlarma;
    }

    public String getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(String diasSemana) {
        this.diasSemana = diasSemana;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Users getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Users idUsuario) {
        this.idUsuario = idUsuario;
    }

    public MusicaMultimedia getIdMusicaMultimedia() {
        return idMusicaMultimedia;
    }

    public void setIdMusicaMultimedia(MusicaMultimedia idMusicaMultimedia) {
        this.idMusicaMultimedia = idMusicaMultimedia;
    }
}
