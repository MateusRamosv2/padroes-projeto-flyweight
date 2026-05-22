package flyweight;

import java.util.HashMap;
import java.util.Map;

public class ModeloVeiculoFactory {
    private static Map<String, ModeloVeiculo> modelos = new HashMap<>();

    public static ModeloVeiculo getModelo(String tipo, String iconeUrl) {
        ModeloVeiculo modelo = modelos.get(tipo);
        if (modelo == null) {
            modelo = new ModeloVeiculo(tipo, iconeUrl);
            modelos.put(tipo, modelo);
        }
        return modelo;
    }

    public static int getTotalModelosEmMemoria() {
        return modelos.size();
    }
}