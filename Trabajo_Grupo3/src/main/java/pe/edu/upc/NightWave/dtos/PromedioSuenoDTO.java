package pe.edu.upc.NightWave.dtos;

public class PromedioSuenoDTO {
    private int idUsuario;
    private double promedioHorasDormidas;
    private double promedioInterrupciones;
    private double promedioEstres;

    public PromedioSuenoDTO() {
    }

    public PromedioSuenoDTO(int idUsuario, double promedioHorasDormidas, double promedioInterrupciones, double promedioEstres) {
        this.idUsuario = idUsuario;
        this.promedioHorasDormidas = promedioHorasDormidas;
        this.promedioInterrupciones = promedioInterrupciones;
        this.promedioEstres = promedioEstres;
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

    public double getPromedioInterrupciones() {
        return promedioInterrupciones;
    }

    public void setPromedioInterrupciones(double promedioInterrupciones) {
        this.promedioInterrupciones = promedioInterrupciones;
    }

    public double getPromedioEstres() {
        return promedioEstres;
    }

    public void setPromedioEstres(double promedioEstres) {
        this.promedioEstres = promedioEstres;
    }
}
