package pe.edu.upc.NightWave.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Alarma")
public class Alarma
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlarma;
    @Column(name = "nombreAlarma", nullable = false, length = 50)
    private String nombreAlarma;
    @Column(name = "horaAlarma", nullable = false)
    private LocalDateTime horaAlarma;
    @Column(name = "diaSemana", nullable = false, length = 50)
    private String diaSemana;
    @Column(name = "activa", nullable = false)
    private boolean activa;
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;


    public Alarma(){}



}
