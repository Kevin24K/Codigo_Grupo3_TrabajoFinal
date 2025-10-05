package pe.edu.upc.NightWave.dtos;

import pe.edu.upc.NightWave.entities.Users;

import java.time.LocalDate;

public class SuenoDTO
{
    private int idSueno;
    private LocalDate fechaRegistro;
    private LocalDate horaAcostarse;
    private LocalDate horaDespertar;
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
