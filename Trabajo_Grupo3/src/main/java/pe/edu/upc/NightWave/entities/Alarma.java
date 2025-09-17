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

    private String nombreAlarma;
    private LocalDateTime horaAlarma;
    private String diaSemana;
    private double volumen;
    private boolean activa;

}
