package pe.edu.upc.NightWave.dtos;

public class ObjetivosAlcanzadosDTO {
    private String nombreUsuario;
    private int objetivosAlcanzados;
    private int objetivosNoAlcanzados;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getObjetivosAlcanzados() {
        return objetivosAlcanzados;
    }

    public void setObjetivosAlcanzados(int objetivosAlcanzados) {
        this.objetivosAlcanzados = objetivosAlcanzados;
    }

    public int getObjetivosNoAlcanzados() {
        return objetivosNoAlcanzados;
    }

    public void setObjetivosNoAlcanzados(int objetivosNoAlcanzados) {
        this.objetivosNoAlcanzados = objetivosNoAlcanzados;
    }
}
