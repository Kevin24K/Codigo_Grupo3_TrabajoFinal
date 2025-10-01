package pe.edu.upc.NigthWave.dtos;

public class PromedioHorasSuenoDTO {
    private int usuarioId;
    private Double promedioHorasDormidas;


    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Double getPromedioHorasDormidas() {
        return promedioHorasDormidas;
    }

    public void setPromedioHorasDormidas(Double promedioHorasDormidas) {
        this.promedioHorasDormidas = promedioHorasDormidas;
    }
}
