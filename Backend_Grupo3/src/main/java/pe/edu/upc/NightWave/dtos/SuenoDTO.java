package pe.edu.upc.NightWave.dtos;

import pe.edu.upc.NightWave.entities.Users;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SuenoDTO
{
    private int idSueno;
    private LocalDate fechaRegistro;
    private LocalDateTime horaAcostarse;
    private LocalDateTime horaDespertar;
    private int calidadSueno;
    private int interrupciones;
    private boolean cafeinaConsumida;
    private String notas;
    private Users idUsuario;

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
