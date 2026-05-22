package flyweight;

public class VeiculoRastreado {
    private String placa;
    private double latitude;
    private double longitude;
    private ModeloVeiculo modelo; // A referência ao objeto compartilhado (Flyweight)

    public VeiculoRastreado(String placa, double latitude, double longitude, ModeloVeiculo modelo) {
        this.placa = placa;
        this.latitude = latitude;
        this.longitude = longitude;
        this.modelo = modelo;
    }

    public String gerarMarcadorMapa() {
        return "VeiculoRastreado{" +
                "placa='" + this.placa + '\'' +
                ", lat=" + this.latitude +
                ", lng=" + this.longitude +
                ", tipo='" + modelo.getTipo() + '\'' +
                ", icone='" + modelo.getIconeUrl() + '\'' +
                '}';
    }
}