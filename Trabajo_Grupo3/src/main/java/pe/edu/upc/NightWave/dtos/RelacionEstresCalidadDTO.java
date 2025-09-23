package pe.edu.upc.NightWave.dtos;

public class RelacionEstresCalidadDTO {
    private int usuarioId;
    private double promedioEstres;
    private double promedioCalidadSueno;
    private double correlacionEstresCalidad;

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public double getPromedioEstres() {
        return promedioEstres;
    }

    public void setPromedioEstres(double promedioEstres) {
        this.promedioEstres = promedioEstres;
    }

    public double getPromedioCalidadSueno() {
        return promedioCalidadSueno;
    }

    public void setPromedioCalidadSueno(double promedioCalidadSueno) {
        this.promedioCalidadSueno = promedioCalidadSueno;
    }

    public double getCorrelacionEstresCalidad() {
        return correlacionEstresCalidad;
    }

    public void setCorrelacionEstresCalidad(double correlacionEstresCalidad) {
        this.correlacionEstresCalidad = correlacionEstresCalidad;
    }
}
