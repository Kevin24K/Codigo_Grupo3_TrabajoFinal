package pe.edu.upc.NightWave.dtos;

public class PromedioSuenoDTO {
    private int idUsuario;
    private double promedioHorasDormidas;
    private double promedioInterrupciones;
    private double promedioCalidad;

    public PromedioSuenoDTO() {
    }

    public PromedioSuenoDTO(int idUsuario, double promedioHorasDormidas, double promedioInterrupciones, double promedioCalidad) {
        this.idUsuario = idUsuario;
        this.promedioHorasDormidas = promedioHorasDormidas;
        this.promedioInterrupciones = promedioInterrupciones;
        this.promedioCalidad = promedioCalidad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getPromedioHorasDormidas() {
        return promedioHorasDormidas;
    }

    public void setPromedioHorasDormidas(double promedioHorasDormidas) {
        this.promedioHorasDormidas = promedioHorasDormidas;
    }

    public double getPromedioCalidad() {
        return promedioCalidad;
    }

    public void setPromedioCalidad(double promedioCalidad) {
        this.promedioCalidad = promedioCalidad;
    }

    public double getPromedioInterrupciones() {
        return promedioInterrupciones;
    }

    public void setPromedioInterrupciones(double promedioInterrupciones) {
        this.promedioInterrupciones = promedioInterrupciones;
    }
}
