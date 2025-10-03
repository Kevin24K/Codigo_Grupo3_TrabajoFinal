package pe.edu.upc.NightWave.dtos;

import pe.edu.upc.NightWave.entities.Habitos;
import pe.edu.upc.NightWave.entities.Users;

import java.time.LocalDate;

public class SeguimientoHabitosDTO
{
    private int idSeguimientoHabitos;
    private boolean completado;
    private int calidadEjecucion;
    private String notas;
    private LocalDate fechaSeguimiento;
    private Users idUsuario;
    private Habitos idHabito;

    public int getIdSeguimientoHabitos() {
        return idSeguimientoHabitos;
    }

    public void setIdSeguimientoHabitos(int idSeguimientoHabitos) {
        this.idSeguimientoHabitos = idSeguimientoHabitos;
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

    public LocalDate getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public void setFechaSeguimiento(LocalDate fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public Users getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Users idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Habitos getIdHabito() {
        return idHabito;
    }

    public void setIdHabito(Habitos idHabito) {
        this.idHabito = idHabito;
    }
}
