package pe.edu.upc.NightWave.dtos;

public class PromedioProgresoDTO {
    private String nombreUsuario;
    private Double promedioProgreso;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Double getPromedioProgreso() {
        return promedioProgreso;
    }

    public void setPromedioProgreso(Double promedioProgreso) {
        this.promedioProgreso = promedioProgreso;
    }
}
