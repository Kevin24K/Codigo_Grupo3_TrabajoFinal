package pe.edu.upc.NigthWave.dtos;

import java.time.LocalDateTime;

public class SeguimientoHabitosDTO
{

    private int id;
    private boolean completado;
    private int calidadEjecucion;
    private String notas;
    private LocalDateTime fechaSeguimiento;
    private int IdUsuario;
    private int IdHabito;

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

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public int getIdHabito() {
        return IdHabito;
    }

    public void setIdHabito(int idHabito) {
        IdHabito = idHabito;
    }

}
