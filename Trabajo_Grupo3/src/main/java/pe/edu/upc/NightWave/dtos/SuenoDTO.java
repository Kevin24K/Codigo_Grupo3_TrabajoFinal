package pe.edu.upc.NightWave.dtos;

import java.time.LocalDateTime;

public class SuenoDTO
{
    private int id;
    private LocalDateTime fechaRegistro;
    private LocalDateTime horaAcostarse;
    private LocalDateTime horaDespertar;
    private int calidadSueno;
    private int interrupciones;
    private boolean cafeinaConsumida;
    private boolean ejercicioRealizado;
    private boolean pantallasAntesDormir;
    private int nivelEstresDia;
    private String notas;
    private Usuario usuario;

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
