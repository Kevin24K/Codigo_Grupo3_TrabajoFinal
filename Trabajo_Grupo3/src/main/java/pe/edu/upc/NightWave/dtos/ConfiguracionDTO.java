package pe.edu.upc.NightWave.dtos;

public class ConfiguracionDTO
{
    private int idConfiguracion;
    private int idUsuario;
    private boolean modoSinDistracciones;
    private boolean modoNocturno;
    private boolean modoAvion;

    public int getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(int idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isModoSinDistracciones() {
        return modoSinDistracciones;
    }

    public void setModoSinDistracciones(boolean modoSinDistracciones) {
        this.modoSinDistracciones = modoSinDistracciones;
    }

    public boolean isModoNocturno() {
        return modoNocturno;
    }

    public void setModoNocturno(boolean modoNocturno) {
        this.modoNocturno = modoNocturno;
    }

    public boolean isModoAvion() {
        return modoAvion;
    }

    public void setModoAvion(boolean modoAvion) {
        this.modoAvion = modoAvion;
    }
}
