package pe.edu.upc.NightWave.dtos;

import pe.edu.upc.NightWave.entities.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;

public class SuenioDTO {
    private int idSuenio;
    private LocalDate fechaRegistro;
    private LocalTime horaAcostarse;
    private LocalTime horaDespertar;
    private String calidadSuenio;
    private Boolean cafeinaConsumida;
    private Boolean ejercicioRealizado;
    private String notas;
    private Usuario usuario;

    public int getIdSuenio() {
        return idSuenio;
    }

    public void setIdSuenio(int idSuenio) {
        this.idSuenio = idSuenio;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalTime getHoraAcostarse() {
        return horaAcostarse;
    }

    public void setHoraAcostarse(LocalTime horaAcostarse) {
        this.horaAcostarse = horaAcostarse;
    }

    public LocalTime getHoraDespertar() {
        return horaDespertar;
    }

    public void setHoraDespertar(LocalTime horaDespertar) {
        this.horaDespertar = horaDespertar;
    }

    public String getCalidadSuenio() {
        return calidadSuenio;
    }

    public void setCalidadSuenio(String calidadSuenio) {
        this.calidadSuenio = calidadSuenio;
    }

    public Boolean getCafeinaConsumida() {
        return cafeinaConsumida;
    }

    public void setCafeinaConsumida(Boolean cafeinaConsumida) {
        this.cafeinaConsumida = cafeinaConsumida;
    }

    public Boolean getEjercicioRealizado() {
        return ejercicioRealizado;
    }

    public void setEjercicioRealizado(Boolean ejercicioRealizado) {
        this.ejercicioRealizado = ejercicioRealizado;
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
