package flyweight;

public class ModeloVeiculo {
    private String tipo;
    private String iconeUrl;

    public ModeloVeiculo(String tipo, String iconeUrl) {
        this.tipo = tipo;
        this.iconeUrl = iconeUrl;
    }

    public String getTipo() {
        return tipo;
    }

    public String getIconeUrl() {
        return iconeUrl;
    }
}