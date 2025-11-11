package pe.edu.upc.NightWave.dtos;

public class ConteoEstresXMesDTO {

    private String mes;
    private int cantidadRegistros;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getCantidadRegistros() {
        return cantidadRegistros;
    }

    public void setCantidadRegistros(int cantidadRegistros) {
        this.cantidadRegistros = cantidadRegistros;
    }
}
