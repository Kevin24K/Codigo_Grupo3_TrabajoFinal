package pe.edu.upc.NightWave.dtos;

import pe.edu.upc.NightWave.entities.Usuario;

import java.time.LocalDate;

public class IntegracionesDTO
{
    private int idIntegracion;
    private Usuario usuario;
    private String dispositivo;
    private String tipo;
    private boolean estado;
    private LocalDate fechaSincronizacion;

    public int getIdIntegracion() {
        return idIntegracion;
    }

    public void setIdIntegracion(int idIntegracion) {
        this.idIntegracion = idIntegracion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDate getFechaSincronizacion() {
        return fechaSincronizacion;
    }

    public void setFechaSincronizacion(LocalDate fechaSincronizacion) {
        this.fechaSincronizacion = fechaSincronizacion;
    }
}
