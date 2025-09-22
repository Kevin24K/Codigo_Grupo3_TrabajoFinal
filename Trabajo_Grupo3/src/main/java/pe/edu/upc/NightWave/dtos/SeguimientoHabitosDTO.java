package pe.edu.upc.NightWave.dtos;

import jakarta.persistence.*;
import pe.edu.upc.NightWave.entities.Habitos;
import pe.edu.upc.NightWave.entities.Usuario;

import java.time.LocalDateTime;

public class SeguimientoHabitosDTO
{

    private int id;
    private boolean completado;
    private int calidadEjecucion;
    private String notas;
    private LocalDateTime fechaSeguimiento;
    private Usuario usuario;
    private Habitos habito;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public int getCalidadEjecucion() {
        return calidadEjecucion;
    }

    public void setCalidadEjecucion(int calidadEjecucion) {
        this.calidadEjecucion = calidadEjecucion;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public LocalDateTime getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public void setFechaSeguimiento(LocalDateTime fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Habitos getHabito() {
        return habito;
    }

    public void setHabito(Habitos habito) {
        this.habito = habito;
    }
}
