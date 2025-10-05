package pe.edu.upc.NightWave.dtos;

public class PromedioEstresDTO {
    private String nombreUsuario;
    private double promedioEstres;
    private double promedioAnsiedad;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public double getPromedioEstres() {
        return promedioEstres;
    }

    public void setPromedioEstres(double promedioEstres) {
        this.promedioEstres = promedioEstres;
    }

    public double getPromedioAnsiedad() {
        return promedioAnsiedad;
    }

    public void setPromedioAnsiedad(double promedioAnsiedad) {
        this.promedioAnsiedad = promedioAnsiedad;
    }
}
